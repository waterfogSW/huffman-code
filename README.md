# Huffman Tree Grenerator

## Steps to build Huffman Tree

1. Create a leaf node for each unique character and build a min heap of all leaf nodes. The value of frequency field is used to compare two nodes in min heap. Initially, the least frequent character is at root.
2. Extract two nodes with the minimum frequency from the min heap
3. Create a new internal node with a frequency equal to the sum of the two nodes frequencies. Make the first extracted node as its left child and the other extracted node as ist right child. Add this node to the min heap.
4. Repeat #2 and #3 until the heap contains only one node. The remaining node is the rrot node and the tree is complete. Let us understand the algorithm with an example.

## usage
- working directory must be cloning folder