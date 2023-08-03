package data_structures.trees;

import java.util.ArrayList;

public class GenericTree {
	String data ; 
	GenericTree parent ;
	ArrayList<GenericTree> childrens;
	
	public GenericTree(String data) {
		this.data = data ; 
		this.parent = null;
		this.childrens = new ArrayList<GenericTree>();
	}
	
	public void addChild(GenericTree node) {
		node.parent = this;
		this.childrens.add(node);
	}
	
	public int getLevel() {
		return getLevel(this , 0);
	}
	
	public int getLevel(GenericTree node , int level) {
		if(node.parent == null) {
			return level;
		}
		return getLevel( node.parent , level + 1);
	}
	
	public String getLine(int length) {
		String line = "  ";
		for ( int i = 0 ; i < length ; i++) {
			line += "  ";
		}
		return line;
	}
	
	public void displayTree() {
		
		int level = this.getLevel();
		
		System.out.print(getLine(level) + "|---");
		System.out.println(this.data);
		
		for (GenericTree child: this.childrens) {
			child.displayTree();
		}
	}
	
	public static void main(String[] args) {
		// code
		GenericTree desktop = new GenericTree("desktop");
		
		GenericTree personal = new GenericTree("personal");
		GenericTree games = new GenericTree("games");
		
		GenericTree videos = new GenericTree("videos");
		GenericTree programs = new GenericTree("programs");
		GenericTree minecraft = new GenericTree("minecraft");
		GenericTree freefire = new GenericTree("freefire");
		
		desktop.addChild(personal);
		desktop.addChild(games);
		
		personal.addChild(videos);
		personal.addChild(programs);
		
		games.addChild(minecraft);
		games.addChild(freefire);
		
		desktop.displayTree();
	
	}
}
