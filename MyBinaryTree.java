public class MyBinaryTree {
    private MyNode root;

    // Subclasse dos nós da Árvore
    private static class MyNode {
        MyNode leftNode;
        MyNode rightNode;
        int data;
        
        public MyNode(int data) {
            this.data = data;
            this.leftNode = null;
            this.rightNode = null;
        }
    }

    // Constructor da Árvore
    public MyBinaryTree(int data) {
        this.root = new MyNode(data);
    }
    
    // Função para adicionar valores para a Árvore
    void insertData(int data) {
        this.root = insertRecursion(this.root, data);
    }

    // Parte recursiva da função de adição
    private MyNode insertRecursion(MyNode node, int data) {
        if (node == null) {
            return new MyNode(data);

        } else {
            if (data < node.data) {
                node.leftNode = insertRecursion(node.leftNode, data);

            } else if (data >= node.data) {
                node.rightNode = insertRecursion(node.rightNode, data);

            }
            return node;
        }
    }

    // Função para verificar se um valor está na árvore
    boolean searchTree(int data) {
        MyNode node = searchRecursion(this.root, data);

        if (node != null && node.data == data) {
            return true;

        } else {
            return false;

        }
    }

    // Parte recursiva da função de busca
    private MyNode searchRecursion(MyNode node, int data) {
        if (node == null) {
            return null;
        }

        if (data < node.data) {
            return searchRecursion(node.leftNode, data);
            
        } else if (data > node.data) {
            return searchRecursion(node.rightNode, data);
            
        }
        return node;
    }

    // Função de deletar um dado da Árvore
    void deleteData(int data) {
        this.root = deleteRecursion(this.root, data);
    }
    
    // Recursividade da função de delete
    MyNode deleteRecursion(MyNode node, int data) {
        if (node == null) {
            return node;

        }
        if (data < node.data) {
            node.leftNode = deleteRecursion(node.leftNode, data);
            return node;

        } else if (data > node.data) {
            node.rightNode = deleteRecursion(node.rightNode, data);
            return node;

        } else {
            if (node.leftNode == null) {
                return node.rightNode;
                
            } else if (node.rightNode == null) {
                return node.leftNode;
                
            } else {
                MyNode succParent = node;
                MyNode succ = node.rightNode;

                while (succ.leftNode != null) {
                    succParent = succ;
                    succ = succ.leftNode;
                }
                
                if (succParent != node) {
                    succParent.leftNode = succ.rightNode;
                    
                } else {
                    succParent.rightNode = succ.rightNode;
                    
                }
                node.data = succ.data;

                System.out.println("O valor " + data + " foi removido com sucesso.");
                
                return node;
            }
        }
    }

    // – = – Função de Print pega da internet 🤙 – = –

    void print2D() {
        // Pass initial space count as 0
        print2DUtil(this.root, 0);
        System.out.println("");
    }

    private void print2DUtil(MyNode root, int space) {
        // Base case
        if (root == null)
            return;
 
        // Increase distance between levels
        space += 10;
 
        // Process right child first
        print2DUtil(root.rightNode, space);
 
        // Print current node after space count
        System.out.print("\n");

        for (int i = 10; i < space; i++)
            System.out.print(" ");

        System.out.print(root.data + "\n");
 
        // Process left child
        print2DUtil(root.leftNode, space);
    }
}