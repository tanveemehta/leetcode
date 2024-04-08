class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int type0 = 0;
        int type1 = 0;
        
        for(int i = 0;i<students.length;i++){
            if(students[i] == 0){
                type0++;
            }
            else{
                type1++;
            }
        }
        int unable2Eat = students.length;
        for(int i = 0;i<sandwiches.length;i++){
            int sandwich = sandwiches[i];
            
            if((sandwich == 0 && type0 > 0)||(sandwich == 1 && type1>0)){
                for(int j = 0;j<students.length;j++){
                    if (students[j] ==  sandwich){
                        students[j] = -1;
                        unable2Eat--;
                        if(sandwich == 0){
                            type0--;
                        }else{
                            type1--;
                        }
                        break;
                    }
                } 
            }
            else{
                 break;
             }
        }
        return unable2Eat;
    }
}