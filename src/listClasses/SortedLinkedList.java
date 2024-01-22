1	package tests; 
2	 
3	import listClasses.BasicLinkedList; 
4	import listClasses.SortedLinkedList; 
5	 
6	public class SampleDriver { 
7	 
8	        public static void main(String[] args) { 
9	                BasicLinkedList<String> basicList = new BasicLinkedList<String>(); 
10	 
11	                basicList.addToEnd("Red").addToFront("Yellow").addToFront("Blue"); 
12	                System.out.println("First: " + basicList.getFirst()); 
13	                System.out.println("Last: " + basicList.getLast()); 
14	                System.out.println("Size: " + basicList.getSize()); 
15	                System.out.println("Retrieve First: " + basicList.retrieveFirstElement()); 
16	                System.out.println("Retrieve Last: " + basicList.retrieveLastElement()); 
17	                System.out.println("Removing Red"); 
18	                basicList.remove("Red", String.CASE_INSENSITIVE_ORDER); 
19	                System.out.print("Iteration: "); 
20	                for (String entry : basicList) { 
21	                        System.out.print(entry + " "); 
22	                } 
23	                 
24	                SortedLinkedList<String> sortedList = new SortedLinkedList<String>(String.CASE_INSENSITIVE_ORDER); 
25	                sortedList.add("Yellow").add("Red"); 
26	                System.out.print("\n\nIteration (for sorted list): "); 
27	                for (String entry : sortedList) { 
28	                        System.out.print(entry + " "); 
29	                } 
30	                sortedList.remove("Red"); 
31	                System.out.print("\nAfter remove in sorted list first is: "); 
32	                System.out.println(sortedList.getFirst()); 
33	        } 
34	} 
