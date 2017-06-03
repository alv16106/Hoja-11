//Rodrigo Alvarado 16106


package hoja11;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;

public class Grafo {
	private Object [][]  edges;  // adjacency matrix
	private static Object [] labels;
	private int [] weights;
	
	public Grafo (int n) {
		edges  = new Object [n][n];
		labels = new Object[n];
		weights = new int[n];
	}

	public int size() { return labels.length; }
	public void   setLabel (int vertex, Object label) { labels[vertex]=label; }
	public Object getLabel (int vertex)               { return labels[vertex]; }
	
	public void    addEdge    (int source, int target, int w)  { edges[source][target] = w; }
	public boolean isEdge     (int source, int target)  { return !edges[source][target].equals(null); }
	public void    removeEdge (int source, int target)  { edges[source][target] = 0; }
	public int     getWeight  (int source, int target)  { return weights[source]; } 
	public int [] neighbors (int vertex) {
		int count = 0;
		for (int i=0; i<edges[vertex].length; i++) {
			if (!edges[vertex][i].equals("")) count++;
		}
		final int[]answer= new int[count];
		count = 0;
		for (int i=0; i<edges[vertex].length; i++) {
			if (weights[i]>0) answer[count++]=i;
		}
		return answer;
	}
	
	public void print () {
		for (int j=0; j<edges.length; j++) {
			System.out.print (labels[j]+": ");
			for (int i=0; i<edges[j].length; i++) {
				if (!edges[j][i].equals("")) System.out.print (labels[i]+":"+edges[j][i]+" ");
			}
			System.out.println ();
		}
	}

	public static void main (String args[]) {
		System.out.println("Seleccione el archivo del que quiere la informacion.");
		int x=1;
		int y =1;
		//Grafo vacio
		final Grafo t = new Grafo (6);
		String a = ""; 
		
		//Se lee el archivo
		JFileChooser archivo = new JFileChooser();
		archivo.showOpenDialog(null);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(archivo.getSelectedFile().getPath()));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String pal;
		try {
			while(reader.ready()){
				while ((pal=reader.readLine())!= null){
					String pueblos[]= pal.split(",");
					labels[x-1]=pueblos[0];
					t.addEdge(x, y, Integer.valueOf(pueblos[2]));
					x++;
					y++;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t.addEdge (5,4,3);
		t.print();
	}

}