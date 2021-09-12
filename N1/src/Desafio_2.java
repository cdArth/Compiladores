package src;


import java.util.ArrayList;
import java.util.List;

import src.Objects.LC;

/**
 * Desafio_2
 */
public class Desafio_2 {
    public static void main(String[] args) {
        try {
           // TXTDAO dao = new TXTDAO();
          //  List<String> list =dao.readFile();
            LC obj = new LC();
            boolean check=false;
          List<LC> list = new ArrayList<LC>();

          obj.setLine("{[]}");
          obj.setCheck(check);
          list.add(obj);
          obj = new LC();
          obj.setLine("([)]");
          obj.setCheck(check);

          list.add(obj);
          obj = new LC();
          obj.setCheck(check);

          obj.setLine("[{()()}[]]");
           
          list.add(obj);
          obj = new LC();
          obj.setCheck(check);
          obj.setLine("{}()[()]]");
          list.add(obj);
          obj = new LC();
          obj.setCheck(check);
          obj.setLine(")[{}]()(");
          list.add(obj); 
          obj = new LC();
          obj.setCheck(check);
          obj.setLine("(()[)]");
          list.add(obj); 
          obj = new LC();
          obj.setCheck(check);
          obj.setLine("<<[]()>>");
          list.add(obj); 
          obj = new LC();
          obj.setCheck(check);
          obj.setLine("<<()[<>}>");
          list.add(obj); 
          
          list=check(list);
          String resp="OK";
        

          for (LC lc : list) {
              if(lc.getCheck()==false)
                resp="Inválido";
              
              System.out.println(lc.getLine()+" "+resp+"\n");
          }

        } catch (Exception e) {
System.out.println("Não vai rolar!"); 
System.out.println(e); 

       }
    }

    public static List<LC> check(List<LC> list1) {
        
        List<List<Character>> list2 =new ArrayList<>();
        List<Character> vchar = new ArrayList<Character>();

        
        List<Character> left = new ArrayList<Character>();
        
        
        
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list1.get(i).getLine().length(); j++) {
                vchar.add(list1.get(i).getLine().charAt(j));
            }
            list2.add(vchar);
            vchar = new ArrayList<Character>();
        }
       for (int i = 0; i < list2.size(); i++) {
           for (int j = 0; j < list2.get(i).size(); j++) {
               
            if (list2.get(i).get(j)=='('||list2.get(i).get(j)=='['||
                list2.get(i).get(j)=='{'||list2.get(i).get(j)=='<') {
                left.add(list2.get(i).get(j));
            } else {//1-{[]} 2-([)]         
                if (left.isEmpty()) {
                    
                    if(i<list2.size()){
                        i++;
                        j=0;
                    }
                    else{
                        break;
                    }
                }
                
                if (list2.get(i).get(j)==')' && left.get(left.size()-1)!='('||
                    list2.get(i).get(j)=='}' && left.get(left.size()-1)!='{'||
                    list2.get(i).get(j)=='>' && left.get(left.size()-1)!='<'||
                    list2.get(i).get(j)==']' && left.get(left.size()-1)!='[') {
                        if(i<list2.size()){
                            i++;
                            j=0;
                        }
                        else{
                            break;
                        }
                    }
                    left.remove(left.size()-1);
                }
                
            }
        
        if(left.isEmpty()){
            String line=list1.get(i).getLine();
            //LC obj = new LC();
            //obj.setLine(line);
            //obj.setCheck(true);
            //list1.get(i).ge=obj;
            list1.get(i).setCheck(true);
        }
       }
       
        return list1;
    }
}