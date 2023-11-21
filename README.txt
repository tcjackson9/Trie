Authors: Henry Einhaus, Tanner Jackson, Frederic Geile

How to run programs:
    The WordSearch program is our Trie implementation. When the program is run,
there are multiples options to choose from to test and use our Trie implementation. 
The other main program is our TrieVsHashtableVsBST program. This program can be run 
and then the user is prompted to enter a 'n' value. This determines the amount of insertions
and searches done on the data structures. The performace of each data structure is printed to
the user.

What is a Trie?
    A Trie is a data structure that is used for finding a specific set of strings quickly.
This searching algorithm uses individual nodes to represent characters in the alphabet. 
Every node can have 26 children, 1 for each charcter in the english alphabet. Each node 
is inserted in alphabetical order, so the tree is probarly sorted. A Trie will typically
have 3 methods, one for insertion, deletion, and searching.

Pros:
-Has alphabetical sorting, so printing words in alphabetical order can be done 
quickly.
-A Trie will be able to insert, sort, and delete any given node in O(n) time.

Cons:
-A Trie takes up a mass amount of space in many cases, as each node can have
many children which leads inefficient space usage.
-A well constructed hash table is able to lookup a value with a best case of O(1) 
which is far faster than a Trie.

Applications:
-Browser History
-Auto-correct
-Auto complete

Comparisons:
-----------------------------------
n=10 (n represents the amount of insertions and searches)
-----------------------------------
Insertion time in Trie: 2602300 ns
Insertion time in Hashtable: 687000 ns
Insertion time in BST: 1283200 ns
Search time in Trie: 65200 ns
Search time in Hashtable: 10200 ns
Search time in BST: 30600 ns
Space complexity of Trie: 3022112 bytes
Space complexity of Hashtable: 3022112 bytes
Space complexity of BST: 3022112 bytes
-----------------------------------
n=100 
-----------------------------------
Insertion time in Trie: 2071200 ns
Insertion time in Hashtable: 963400 ns
Insertion time in BST: 4571100 ns
Search time in Trie: 289100 ns
Search time in Hashtable: 57100 ns
Search time in BST: 1198100 ns
Space complexity of Trie: 3022032 bytes
Space complexity of Hashtable: 3022032 bytes
Space complexity of BST: 3022032 bytes
-----------------------------------
n=1,000
-----------------------------------
Insertion time in Trie: 15966500 ns
Insertion time in Hashtable: 9395200 ns
Insertion time in BST: 22962300 ns
Search time in Trie: 2252300 ns
Search time in Hashtable: 670500 ns
Search time in BST: 13904200 ns
Space complexity of Trie: 3483488 bytes
Space complexity of Hashtable: 3483488 bytes
Space complexity of BST: 3483488 bytes
-----------------------------------
n=10,000
-----------------------------------
Insertion time in Trie: 27302200 ns
Insertion time in Hashtable: 43421100 ns
Insertion time in BST: 239777200 ns
Search time in Trie: 6188600 ns
Search time in Hashtable: 7647800 ns
Search time in BST: 215892400 ns
Space complexity of Trie: 9313456 bytes
Space complexity of Hashtable: 9313456 bytes
Space complexity of BST: 9313456 bytes
-----------------------------------
n=100,000
-----------------------------------
Insertion time in Trie: 177355800 ns
Insertion time in Hashtable: 3559033600 ns
Insertion time in BST: 7482089600 ns
Search time in Trie: 34162400 ns
Search time in Hashtable: 19799300 ns
Search time in BST: 6173085000 ns
Space complexity of Trie: 68982648 bytes
Space complexity of Hashtable: 68982648 bytes
Space complexity of BST: 68982648 bytes
