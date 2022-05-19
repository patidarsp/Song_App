package com.sachin;
import java.util.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

	private static ArrayList<Album> albums=new ArrayList<>();

	public static void main(String args[]) {
		
		Album album=new Album("Album1","AC/DC");
		
		album.addsong("happy happy",4.5);
		album.addsong("Highway to hell",5.5);
		album.addsong("The Darkness",3.5);
		albums.add(album);
		 album=new Album("Album2","Aminem");
		 
		 album.addsong("rap god",4.7);
		 album.addsong("Saregama",5.0);
		 album.addsong("lose yourself",3.8);
		 albums.add(album);
		 
		 LinkedList<Song> PlayList_1=new LinkedList<>();
		 
		 albums.get(0).addToPlayList("Highway to hell",PlayList_1);
		 albums.get(0).addToPlayList("The Darkness",PlayList_1);
		 albums.get(1).addToPlayList("rap god",PlayList_1);
		 albums.get(1).addToPlayList("lose yourself",PlayList_1);
		 
		 play(PlayList_1);
	}
	
	private static void play(LinkedList<Song> playList) {
		Scanner sc=new Scanner(System.in);
		boolean quit=false;
		boolean forward=true;
		ListIterator<Song> listIterator = playList.listIterator();
		
		if(playList.size()==0) {
			System.out.println("this playList have no song");
		}else {
			System.out.println("now playing"+ listIterator.next().toString());
		    printMenu();
		}
		while(!quit) {
			int action=sc.nextInt();
			sc.nextLine();
			
			switch(action) {
			
			 case 0:
				 System.out.println("playlist is complite");
			     break;
			     
			 case 1:
				   if(!forward) {
					   if(listIterator.hasNext()) {
						   listIterator.next();
					   }
					   forward=true;
				   }
			     if(listIterator.hasNext()) {
			    	 System.out.println("now playing"+listIterator.next().toString());
			     }else {
			    	 System.out.println("no song available reached to the end of list");
			    	 forward=false;
			     }
			     break;
			     
			 case 2:
				  if(forward) {
					  if(listIterator.hasPrevious()) {
						  listIterator.previous();
					  }
					  forward=false;
				  }
				  if(listIterator.hasPrevious()) {
					  System.out.println("now playing"+ listIterator.previous().toString());
					  
				  }else {
					  System.out.println("we are the first song");
					  forward=false;
				  }
				  break;
				  
			 case 3:
			      if(forward) {
			    	  if(listIterator.hasPrevious()) {
			    		  System.out.println("now playing"+ listIterator.previous().toString());
			    		  forward=false;
			    	  }else {
			    		  System.out.println("we are at the start of the list");
			    	  }
			      }else {
			    	  if(listIterator.hasNext()) {
			    		  System.out.println("now playing"+ listIterator.next().toString());
			    		  forward=true;
			    	  }else {
			    		  System.out.println("we have reached to the end of list");
			    	  }
			      }
			        break;
			        
			 case 4:
				 printList(playList);
				 break;
				 
			 case 5:
			      printMenu();
			      break;
			    
			 case 6:
				 if(playList.size()>0) {
					 listIterator.remove();
					 if(listIterator.hasNext()) {
						System.out.println("now playing "+ listIterator.next().toString());
		
					 }
					 else {
						 if(listIterator.hasPrevious())
						 System.out.println("now playing"+ listIterator.previous().toString());
					 }
				 }
		}
	}
}
	private static void printMenu() {
		System.out.println("Available option \n press");
		System.out.println("0 - to quit \n" +
				            "1 - to play next song \n" +
				             "2 - to play previous song \n" +
				             "3 - to replay to current song \n" +
				             "4 - list of all songs \n" +
				             "5 - print all available option \n" +
				             "6 - delete current song");
		}
	
	private static void printList(LinkedList<Song> playList) {
		Iterator<Song> iterator = playList.iterator();
		System.out.println("------------------------");
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("------------------------");
		
	}
}
