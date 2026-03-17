import java.util.*;
import java.io.*;
class FileManager
{
    static Scanner scan = new Scanner(System.in);
    static File folder;
    static File file;
    static int choice;
    static int ch;
    static String folderName;
    public static void main(String args[])
    {
        System.out.println("\t\t\t\t\tFILE MANAGEMENT");
        System.out.println("\n\t\t1.Create New Folder\n\t\t2.Create New File\n\t\t3.Add Content To the file\n\t\t4.Read Content to the file\n\t\t5.Delete the file\n\t\t6.Delete the Folder\n\t\t7.Current File Name\n\t\t8.Current Folder Name\n\t\t9.Folder Rename\n\t\t10.File Rename\n\t\t11.Exit");
        do
        {
            System.out.print("\n\t\tEnter Your Choice: ");
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    scan.nextLine();
                    System.out.print("\n\t\tEnter Your Folder Name: ");
                    folderName = scan.nextLine();
                    folder = new File("C:\\Users\\MAC PRO\\Desktop\\"+folderName);
                    if(folder.mkdir())
                    {
                        System.out.println("\n\t\tFolder is successfully Created");
                    }
                    break;

                case 2:
                    scan.nextLine();
                    System.out.print("\n\t\tEnter Your File Name: ");
                    String fileName = scan.nextLine();
                    file = new File("C:\\Users\\MAC PRO\\Desktop\\"+folderName+"\\"+fileName);
                    try
                    {
                        boolean filecheck = file.createNewFile();
                        if(filecheck)
                        {
                            System.out.println("\n\t\tFile is Successfully Created");
                        }
                        else
                        {
                            System.out.println("\n\t\tFile is Already Exists");
                        }
                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }
                    break;

                case 3:
                    scan.nextLine();
                    System.out.print("\n\t\tAdd Content To Add: ");
                    String content = scan.nextLine();
                    try
                    {
                        FileWriter filewriter = new FileWriter(file,true);
                        filewriter.write(content);
                        filewriter.flush();
                        filewriter.close();
                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }
                    break;

                case 4:
                    try
                    {
                        FileReader filereader = new FileReader(file);
                        while((ch = filereader.read()) != -1)
                        {
                            System.out.print("\n\t\t"+(char)ch);
                        }           
                    }
                    catch(Exception e)
                    {   
                        if(ch != -1)
                        {
                        System.out.println("\n\t\tSuccessfully file readed");
                        }
                        else
                        {
                            System.out.println("\n\t\tAdd any Content first the file is Empty");
                        }
                    }
                    break;
            
                case 5:
                    {  
                        file.delete();
                        System.out.println("\n\t\tCurrent file is deleted");
                    }
                    break;
            
                case 6:
                    {
                        folder.delete();
                        System.out.println("\n\t\tCurrent Folder is Deleted");
                    }
                    break;
                
                case 7:
                    {
                        try
                        {
                            System.out.print("\n\t\t"+file.getName()); 
                            break;
                        }
                        catch(Exception e)
                        {
                            System.out.println("\n\t\tUndefiened File");
                        }
                    }
                    break;
                case 8:
                    {
                        try
                        {
                            System.out.println("\n\t\t"+folder.getName());
                            break;
                        }
                        catch(Exception e)
                        {
                            System.out.println("\n\t\tUndefined Folder");
                        }
                    }
                    break;

                case 10:
                    {
                        scan.nextLine();
                        System.out.print("\n\t\tEnter Your New File Name: ");
                        String NewFileName = scan.nextLine();
                        File renamedFile = new File("C:\\Users\\MAC PRO\\Desktop\\"+folderName+"\\"+NewFileName);
                        if(file.renameTo(renamedFile))
                        {
                            file = renamedFile;
                            System.out.println("\n\t\tRenamed Successfully");
                        }
                        else
                        {
                            System.out.println("\n\t\tRename Failed");
                        }
                        break;
                    }
                
                case 9:
                    {
                        scan.nextLine();
                        System.out.print("\n\t\tEnter Your New Folder Name: ");
                        String NewFolderName = scan.nextLine();
                        File renameFolder = new File("C:\\Users\\MAC PRO\\Desktop\\"+NewFolderName);
                        if(folder.renameTo(renameFolder))
                        {
                            folder  = renameFolder;
                            System.out.println("\n\t\tFolder Renamed Successfully");
                        }
                        else
                        {
                            System.out.println("\n\t\tRename Folder Failed");
                        }
                        break;
                    }
                case 11:
                    {
                        System.out.println("\n\t\tProcess Ends Thank You");           
                    }
                    break;
                default:
                    break;
            }
        }while(choice != 11);
    }   
}




