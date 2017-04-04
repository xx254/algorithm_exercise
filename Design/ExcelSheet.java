/*
Input:
    3 2
    A2
    4 5 *
    A1
    A1 B2 / 2 +
    3
    39 B1 B2 * /
Output:
    20.00000
    20.00000
    20.00000
    8.66667
    3.00000
    1.50000
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static Cell[][] cells;

    Solution(int m, int n){
        this.cells = new Cell[m][n];
    }

    public class Cell {
        int row;
        int col;
        String input;
        double value = -1;
        ArrayList<Cell> canSupport;
        Cell(String input) {
            this.input = input;
        }
        Cell(int row, int col, String input) {
            this.row = row;
            this.col = col;
            this.input = input;
        }
    }
    
    // Calculate the value of a cell given row and column
    public Double calculate_by_pos(int row, int col){
        String[] parts = cells[row][col].input.split(" ");
        cells[row][col].value = calculate(parts);
        return cells[row][col].value;
    }
    
    // Calculate the value of a cell
    public Double calculate(String[] parts){

        Stack<Double> st = new Stack<Double>();
        Double a, b;

        for(String s : parts) {
            if(this.isReference(s)){
                st.push(this.getValue(s));
            }
            else if(s.equals("+")) {
                st.push(st.pop() + st.pop());
            }

            else if(s.equals("-")){
                a = st.pop();
                b = st.pop();
                st.push(b - a);
            }
            else if(s.equals("*")){
                st.push(st.pop() * st.pop());
            }
            else if(s.equals("/")){
                a = st.pop();
                b = st.pop();
                st.push(b / a);
            }
            else{
                // extra credits
                if(s.startsWith("--")){
                    st.push(-1 + Double.parseDouble(s.substring(2)));
                }
                else if(s.endsWith("--")){
                    st.push(-1 + Double.parseDouble(s.substring(0, s.length()-2)));
                }
                else if(s.startsWith("++")){
                    st.push(1 + Double.parseDouble(s.substring(2)));
                }
                else if(s.endsWith("++")){
                    st.push(1 + Double.parseDouble(s.substring(0, s.length()-2)));
                }
                else if(s.startsWith("-")){
                    st.push((-1) * Double.parseDouble(s.substring(1)));
                }
                else{
                    st.push(Double.parseDouble(s));
                }
            }
        }
        return st.pop();
    }

    // Help check whether value has been updated
    public Double getValue(String part){

        int row = getRow(part);
        int col = getCol(part);

        if(cells[row][col].value == -1){
            return calculate_by_pos(row, col);
        }

        return cells[row][col].value;
    }

    // Decide if it`s reference (rather than number with operator)
    public boolean isReference(String s) {
        String letter=".*[A-Z].*";
        if(s.matches(letter)){
            return true;
        }
        return false;
    }


    int getRow(String s) {
        return s.charAt(0)-65;
    }

    int getCol(String s){
        return Integer.parseInt(s.substring(1)) - 1;
    }

    // Build dependency relationship among cells
    public void BuildDependencies(Cell[][] cells, int m, int n) {

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(this.isReference(cells[i][j].input)){
                    String[] parts = cells[i][j].input.split(" ");
                    for(String part: parts){
                        if(this.isReference(part)) {
                            int row = getRow(part);
                            int col = getCol(part);
                            cells[row][col].canSupport.add(cells[i][j]);
                        }
                    }
                }
            }
        }
    }

    // Decide which cell to calculate first using topological sort algorithm
    public boolean topSort(Cell[][] cells, int m, int n) {
        int count = 0;
        Cell cell = cells[0][0];
        HashMap<Cell, Integer> map = new HashMap();
        Queue<Cell> q = new LinkedList<Cell>();

        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                cell = cells[i][j];

                if(!this.isReference((cell.input))){
                    q.offer(cell);
                }

                for(Cell post: cell.canSupport){
                    if (map.containsKey(post)) {
                        map.put(post, map.get(post) + 1);
                    } else {
                        map.put(post, 1);
                    }
                }

            }
        }

        while (!q.isEmpty()) {
            cell = q.poll();
            count++;
            cell.value = calculate_by_pos(cell.row, cell.col);
            for (Cell c : cell.canSupport) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    q.offer(c);
                }
            }
        }
        return count == m * n;
    }

    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        Solution s = new Solution(m, n);
        // Input
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++) {
                String in = sc.nextLine();
                cells[i][j] = s.new Cell(i, j, in);
                cells[i][j].canSupport = new ArrayList<Cell>();
            }
        }
        
        s.BuildDependencies(cells, m, n);
        
        if(!s.topSort(cells, m, n)){
            System.out.println("Error: Circular dependency!");
        }
        else{
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    System.out.println(String.format("%.5f", s.cells[i][j].value));
                }
            }
        }
    }
}