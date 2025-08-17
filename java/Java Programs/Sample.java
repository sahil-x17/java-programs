import java.util.*;
class Sample
{

String name;
int age;
void accept()
{

Scanner in=new Scanner(System.in);
System.out.println("Enter name and age");
name=in.nextLine();
age=in.nextInt();

}
void display()
{

System.out.println("Name=" + name);
System.out.println("Age=" + age);

}

public static void main(String args[])

{

Sample s[]=new Sample[5];

for (int i=0;i<5;i++)
s[i] = new Sample();

for (int i=0;i<5;i++)
s[i].accept();
for (int i=0;i<5;i++)
s[i].display();

}
}