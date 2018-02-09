package singlylinklist;

import java.util.Scanner;



class Node2

{

	protected int data;

	protected Node2 link;

	

	public Node2()

	{

		link = null;

		data = 0;

	}

	

	public Node2(int d, Node2 n) {

		data = d;

		link = n;

	}

	

	public void setLink(Node2 n)

	{

		link = n;

	}

	

	public void setData(int d)

	{

		data = d;

	}

	

	public Node2 getLink()

	{

		return link;

	}

	

	public int getData()

	{

		return data;

	}

}



class linkedList2

{

	protected Node2 start;

	protected Node2 end;

	public int size;

	

	public linkedList2()

	{

		start = null;

		end = null;

		size = 0;

	}

	public int getSize()

	{

		return size;

	}

	public void insertAtEnd(int val)

	{

		Node2 nptr = new Node2(val, null);

		size++;

		if (start == null)

		{

			start = nptr;

			end = start;

		}

		else

		{

			end.setLink(nptr);

			end = nptr;

		}

	}

	

	public void insertAtPos(int val, int pos)

	{

		Node2 nptr = new Node2(val, null);

		Node2 ptr = start;

		pos = pos - 1;

		for (int i = 1; i < size; i++)

		{

			if (i == pos)

			{

				Node2 tmp = ptr.getLink();

				ptr.setLink(nptr);

				nptr.setLink(tmp);

				break;

			}

			ptr = ptr.getLink();

		}

		size++;

	}

	

	public void deleteAtPos(int pos)

	{

		if (pos == 1)

		{

			start = start.getLink();

			size--;

			return;

		}

		if (pos == size)

		{

			Node2 s = start;

			Node2 t = start;

			while (s != end)

			{

				t = s;

				s = s.getLink();

			}

			end = t;

			end.setLink(null);

			size--;

			return;

		}

		Node2 ptr = start;

		pos = pos - 1;

		for (int i = 1; i < size - 1; i++)

		{

			if (i == pos)

			{

				Node2 tmp = ptr.getLink();

				tmp = tmp.getLink();

				ptr.setLink(tmp);

				break;

			}

			ptr = ptr.getLink();

		}

		size--;

	}

	

	public void display()

	{

		System.out.print("\nSingly Linked List = ");

		if (size == 0)

		{

			System.out.print("empty\n");

			return;

		}

		if (start.getLink() == null)

		{

			System.out.println(start.getData());

			return;

		}

		Node2 ptr = start;

		System.out.print(start.getData() + "->");

		ptr = start.getLink();

		while (ptr.getLink() != null)

		{

			System.out.print(ptr.getData() + "->");

			ptr = ptr.getLink();

		}

		System.out.print(ptr.getData() + "\n");

	}

	public void deleteGreaterNode(int val)

	{

		int deletedNodes = 0;
		int currentIndex = 1; // check if 1 or 0
		// System.out.println(start);
		Node2 ptr = start;
		// ptr = start.getLink();

		while (ptr.getLink() != null) {

			if (val < ptr.getData()) {

				deleteAtPos(currentIndex);
				deletedNodes++;

			} else {
				currentIndex++;
			}
			ptr = ptr.getLink();
		}

		if (val < ptr.getData()) {
			deleteAtPos(currentIndex);
		}

	}
}

public class SinglyLinkedList2

{

	public static void main(String[] args)

	{

		Scanner scan = new Scanner(System.in);

		

		linkedList2 list = new linkedList2();

		System.out.println("Singly Linked List Test\n");

		char ch;

		

		do

		{

			System.out.println("\nSingly Linked List Operations\n");

			System.out.println("1. Append an element into the linkedlist");

			System.out.println("2. Remove the tail element from a linkedlist");

			System.out.println("3. Remove all element in the linkedlist that is great than a target value");
			int choice = scan.nextInt();

			switch (choice)

			{

			case 1:

				System.out.println("Enter integer element to insert");

				list.insertAtEnd(scan.nextInt());

				break;

			case 2:

				// System.out.println("Enter position");

				int p = list.getSize();
				list.deleteAtPos(p);

				break;

			case 3:

				System.out.println("Enter integer element");

				int val = scan.nextInt();
				list.deleteGreaterNode(val);

				break;

			default:

				System.out.println("Wrong Entry \n ");

				break;

			}

			

			list.display();

			System.out.println("\nDo you want to continue (Type y or n) \n");

			ch = scan.next().charAt(0);

		} while (ch == 'Y' || ch == 'y');

	}

}