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
    static String fileName ;
    static File currentFolder = new File("C:\\Users\\MAC PRO\\Desktop");
    static File currentFile = null;
    public static void main(String args[])
    {
        System.out.println("\t\t\t\t\tFILE MANAGEMENT");
        System.out.println("\n\t\t1.Create New Folder\t\t\t8.Current File Name\n\t\t2.Create New File\t\t\t9.Current Folder Name\n\t\t3.Add Content\t\t\t\t10.File Rename\n\t\t4.Read Content\t\t\t\t11.Folder Rename\n\t\t5.Go To File\t\t\t\t12.Delete File\n\t\t6.Go To Folder\t\t\t\t13.Delete Folder\n\t\t7.Copy\t\t\t\t\t14.Exit");
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
                    fileName = scan.nextLine();
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
                        System.out.println("\n\t\tProblem Occured While File Creation");
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
                        System.out.println("\n\t\tContent Not Updated");
                    }
                    break;

                case 4:
                    try
                    {
                        FileReader filereader = new FileReader(file);
                        while((ch = filereader.read()) != -1)
                        {
                            System.out.print("\t\t"+(char)ch);
                        }         
                        filereader.close();  
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
                        scan.nextLine();
                        System.out.print("\n\t\tEnter Your Exact File Path: ");
                        String filepath = scan.nextLine();
                        File tempFile = new File(filepath);
                        if(tempFile.exists() && tempFile.isFile())
                        {
                            currentFile = tempFile;
                            currentFolder = tempFile.getParentFile();
                            System.out.println("\n\t\tNoe You Are In: "+ currentFile.getAbsolutePath());
                        }
                        else
                        {
                            System.out.print("\n\t\tFile Path is Wrong Check It");
                        }
                    }
                    break;

                case 6:
                    {
                        scan.nextLine();
                        System.out.print("\n\t\tEnter Your Location Folder: ");
                        String goFolderName = scan.nextLine();
                        try
                        {
                            FileInputStream gofo = new FileInputStream("..\\"+goFolderName);
                        }
                        catch(Exception e)
                        {
                            System.out.println("\n\t\tFolder Not Found");
                        }
                    }
                    break;

                case 7:
                    {
                        try
                        {
                            scan.nextLine();
                            System.out.print("\n\t\tEnter Your Full Source Path: ");
                            String sourcepath = scan.nextLine();
                            System.out.print("\n\t\tEnter Your Full Desination Path: ");
                            String Desipath = scan.nextLine();
                            File sourceFile = new File(sourcepath);
                            File desiFile = new File(Desipath);
                            if(!sourceFile.exists())
                            {
                                System.out.println("\n\t\t--Source File is Not Found--");
                                break;
                            }
                            if(!desiFile.exists())
                            {
                                System.out.println("\n\t\t--Desination File is NOt Found--");
                                desiFile.createNewFile();
                            }
                            FileInputStream sfile = new FileInputStream(sourceFile);
                            FileOutputStream dfile = new FileOutputStream(desiFile);
                            int i;
                            while((i = sfile.read()) != -1)
                            {
                                dfile.write(i);
                            }
                            System.out.println("\n\t\t---File is successsfully copied---");
                        }
                        catch(Exception e)
                        {
                            System.out.println("\n\t\tProblem occrued in File Copy");
                        }

                    }
                    break;
                case 12:
                    {  
                        file.delete();
                        System.out.println("\n\t\tCurrent file is deleted");
                    }
                    break;
            
                case 13:
                    {
                        folder.delete();
                        System.out.println("\n\t\tCurrent Folder is Deleted");
                    }
                    break;
                
                case 8:
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
                case 9:
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
                
                case 11:
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
                case 14:
                    {
                        System.out.println("\n\t\tProcess Ends Thank You");           
                    }
                    break;
                default:
                    break;
            }
        }while(choice != 14);
    }   
}




//before:
//see the print line after the file manager top heading : need to update three operation copy , go to file, go to folder. carfull watch the (case numbers eg:case 3:)

//after
//i havae slove some thing like i have done the copy and goto file and folder code but the excution process problem occurs find and slove the problem

//afer somtime (after day):-
//probleam not solved at 6,7,5 goto fil,folder,and copy this is problem the work is not done properly.

//mostly 6,7,5 are have small error fix it 
