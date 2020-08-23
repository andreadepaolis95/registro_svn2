package utilities;

public class MonthFactory {


     public MonthFactory(){};

     public Month createMonth(int index,int y){

         System.out.println(index);
         int i = index;
         int year = y;

         if(index == 13){
             i = 1;
             year = year +1;
         }else if( index == 0){
             year = year -1;
             i = 12;
         }

         switch (i){

             case 1:
                 return new Month(i,31,"Jan", year);
             case 2:
                 return new Month(i,28,"Feb",year);
             case 3:
                 return new Month(i,31,"Mar",year);
             case 4:
                 return new Month(i,30,"Apr",year);
             case 5:
                 return new Month(i,31,"May",year);
             case 6:
                 return new Month(i,30,"Jun",year);
             case 7:
                 return new Month(i,31,"Jul",year);
             case 8:
                 return new Month(i,31,"Aug",year);
             case 9:
                 return new Month(i,30,"Sep",year);
             case 10:
                 return new Month(i,31,"Oct",year);
             case 11:
                 return new Month(i,30,"Nov",year);
             case 12:
                 return new Month(i,31,"Dec",year);
             default:
                 return null;
         }

     }

}
