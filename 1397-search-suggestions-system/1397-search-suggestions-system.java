class Solution {
    final int SUGGESTIONS_LIST_CAPACITY = 3;
    final int NUM_SUGGESTIONS = 3;

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        if (products == null || searchWord == null || searchWord.length() == 0) {
            return Collections.emptyList();
        }

        Trie trie = new Trie();
        for (String p: products) {
            trie.insert(p);
        }
        List<List<String>> suggestions = new ArrayList(searchWord.length());

        /*
// start index of the substring yet to be found in the Trie
        int start=0;
        TrieNode node = root;
        TrieEdge edge = null;
        while (start < prefix.length() && node != null) {
            edge = node.getEdgeStarting(prefix.charAt(start));
            if (edge != null
                && edge.string.startsWith(
                    prefix.substring(start, Math.min(prefix.length(), start + edge.string.length()))
                )
            ) {
                start = Math.min(prefix.length(), start + edge.string.length());
                node = edge.toNode;
            } else {
                break;
            }
        }
        */


        Trie.TrieNode node = trie.root;
        Trie.TrieEdge edge = null;
        int edgePos = 0;
        StringBuilder prefix = new StringBuilder(searchWord.length());// to reduce cost when appending edges (suffixes)
        for (int i = 0; i < searchWord.length(); i++) {
            if (edge == null) {
                edge = node.getEdgeStarting(searchWord.charAt(i));
                if (edge == null) break;
                edgePos = 0;
            } else if (edge.string.charAt(++edgePos) != searchWord.charAt(i)) {
                break;
            }
            suggestions.add(getFirstNDescendants(edge, NUM_SUGGESTIONS, prefix));
            
            if (edgePos == edge.string.length() - 1) {
                node = edge.toNode;
                prefix.append(edge.string);
                edge = null;
            }
        }

        //if suggestions could not be found after some characters, then fill remaining with emptyList()
        suggestions.addAll(Collections.nCopies(searchWord.length() - suggestions.size(), Collections.emptyList()));
        return suggestions;
    }

    protected List<String> getFirstNDescendants (Trie.TrieEdge edge, int n, StringBuilder prefix) {
        List<String> descendants = new ArrayList(n);
        prefix.append(edge.string);
        if (edge.toNode.isWordEnd) descendants.add(prefix.toString());
    
        for (char c = 'a'; descendants.size() < n && c <= 'z'; c++) {
            Trie.TrieEdge nextEdge = edge.toNode.getEdgeStarting(c);
            if (nextEdge != null) descendants.addAll(getFirstNDescendants(nextEdge, n - descendants.size(), prefix));
        }

        prefix.setLength(prefix.length() - edge.string.length());
        return descendants;
    }

    public List<List<String>> suggestedProductsBak(String[] products, String searchWord) {
        if (products == null || searchWord == null || searchWord.length() == 0) {
            return Collections.emptyList();
        }

        Arrays.sort(products);

        List<List<String>> suggestions = new ArrayList(searchWord.length());
        // i: index of character to be matched;
        // matchedProduct: smallest index in products that matches upto i th character
        for (int i = 0, matchedProduct = 0; i < searchWord.length(); i++) {
            char searchedChar = searchWord.charAt(i);
            // number of positions by which matchedProduct is increased
            int increments = 0;
            int previousSuggestionCount = suggestions.size() == 0? 0 : suggestions.get(suggestions.size() - 1).size();
            
            while (matchedProduct < products.length
             && (products[matchedProduct].length() <= i
             || (products[matchedProduct].length() > i
             && products[matchedProduct].charAt(i) < searchedChar) )
            )  {
                  matchedProduct++; 
                  increments++;
            }

            if (matchedProduct < products.length 
                && validateProduct(products[matchedProduct], i, searchWord, increments >= previousSuggestionCount
                   ) 
            ) {
                List<String> suggestionsForIChars = new ArrayList(SUGGESTIONS_LIST_CAPACITY);
                suggestions.add(suggestionsForIChars);
                
                suggestionsForIChars.add(products[matchedProduct]);

                if (matchedProduct +1 < products.length 
                    && validateProduct(products[matchedProduct + 1], i, searchWord, increments + 1 >= previousSuggestionCount ) 
                ) {
                    suggestionsForIChars.add(products[matchedProduct + 1]);
                     
                    if (matchedProduct +2 < products.length 
                    && validateProduct(products[matchedProduct + 2], i, searchWord, increments + 2 >= previousSuggestionCount ) 
                    ) {
                        suggestionsForIChars.add(products[matchedProduct + 2]);
                    }
                }
                
            } else {
                break;
            }
        }

        suggestions.addAll(Collections.nCopies(searchWord.length() - suggestions.size() , Collections.emptyList() ) );
        return suggestions;
    }

    protected boolean validateProduct (String product, int i, String searchWord, boolean valdiateFullPrefix) {
        if (valdiateFullPrefix) return product.startsWith(searchWord.substring(0, i+1));
        else return product.length() > i && product.charAt(i) == searchWord.charAt(i);
    }
}

class Trie {

    public Trie() {
        
    }
    
    public void insert(String word) {
        //entries.add(word);

        // start index of the substring yet to be inserted into the Trie
        int start=0;
        TrieNode node = root;
        while (start < word.length()) {
            TrieEdge edge = node.getEdgeStarting(word.charAt(start));

            if (edge == null) {//no edge having common prefix
                TrieNode leaf = new TrieNode();
                leaf.isWordEnd = true;

                edge = new TrieEdge();
                edge.toNode = leaf;
                edge.string = word.substring(start); 
                node.setEdge(word.charAt(start), edge);

                start = word.length();
                node = leaf;
            } else {
                // find the common prefix of the edge and remaining part of word 
                int commonPrefixLength = 1;
                while ( commonPrefixLength < edge.string.length()
                    && start + commonPrefixLength < word.length()
                    && word.charAt(start + commonPrefixLength) == edge.string.charAt(commonPrefixLength)
                ) {
                    commonPrefixLength++;
                }

                if (commonPrefixLength == edge.string.length()) {
                    node = edge.toNode;
                    start += commonPrefixLength;
                } else {
                    TrieNode newNode = new TrieNode();
                    TrieEdge newEdge = new TrieEdge();
                    newEdge.string = edge.string.substring(0,commonPrefixLength);
                    newEdge.toNode = newNode;
                    
                    node.setEdge(edge.string.charAt(0), newEdge);
                    newNode.setEdge(edge.string.charAt(commonPrefixLength), edge);
                    edge.string = edge.string.substring(commonPrefixLength);

                    node = newNode;
                    start += commonPrefixLength;
                }

                if (start == word.length()) {
                    node.isWordEnd = true;
                }
            }
        }
    }
    
    public boolean search(String word) {
        // start index of the substring yet to be found in the Trie
        int start=0;
        TrieNode node = root;
        while (start < word.length()) {
            TrieEdge edge = node.getEdgeStarting(word.charAt(start));
            if (edge != null
                && word.startsWith(edge.string, start)
            ) {
                start += edge.string.length();
                node = edge.toNode;
            } else {
                break;
            }
        }
        /*if (entries.contains(word) && start != word.length()) {
            throw new RuntimeException("word present but not matched in trie. word:"+word + " matched chars:" + start);
        } else if (!entries.contains(word) && start == word.length() && node.isWordEnd) {
            throw new RuntimeException("word not present but all chars mathced:" + word);
        }*/
        return start == word.length() && node.isWordEnd;
        //return entries.contains(word);
    }

    public boolean startsWith(String prefix) {
    // start index of the substring yet to be found in the Trie
        int start=0;
        TrieNode node = root;
        TrieEdge edge = null;
        while (start < prefix.length() && node != null) {
            edge = node.getEdgeStarting(prefix.charAt(start));
            if (edge != null
                && edge.string.startsWith(
                    prefix.substring(start, Math.min(prefix.length(), start + edge.string.length()))
                )
            ) {
                start = Math.min(prefix.length(), start + edge.string.length());
                node = edge.toNode;
            } else {
                break;
            }
        }
        return start == prefix.length();
    }

    protected TrieNode root = new TrieNode();
    //protected Set<String> entries = new HashSet();

    protected static class TrieNode {
        TrieEdge[] edges = null;
        protected boolean isWordEnd;
        protected void checkAndInitEdgeList() {
            if (edges == null) edges = new TrieEdge['z'-'a' + 1];
        }

        protected TrieEdge getEdgeStarting (char c) {
            return edges != null ? edges [c-'a'] : null;
        }

        protected void setEdge (char c, TrieEdge edge) {
            checkAndInitEdgeList();
            edges[c-'a'] = edge;
        }
    }

    protected static class TrieEdge {
        String string;
        TrieNode toNode;
    }
}