
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class Main {
        public static void main(String[] args){
                String[] nameTab={"Kamil","Arek","Zbyszek","Zofia","Kamil","Arek","Zbyszek","Zofia","Kamil","Arek","Kuba","Patrycja"};
                int[] tab={1,2,3,4,5,6,1,2,4,5,6};
                //namesPlusQuantity(nameTab);

                int[] tab2={1, 3, 1, 4, 2, 3, 5, 4};
                System.out.println(solutionLinkedList(new int[] {4, 3, 2, 1, 5}, new int[] {0, 1, 0, 0, 0}));
                System.out.println(12345+5432);

        }
        /*public static int[] countNonDivisible2(int[] tab){
                int[] tabTmp=tab;
                Arrays.sort(tabTmp);
                Map<Integer,Integer> map=new HashMap<>();
                for(int i=0; i<tab.length;i++){
                        int count=0;
                        int jGlobal=0;
                        for(int j=0;j<i;j++){
                                if(tabTmp[i]%tabTmp[j]!=0){
                                        count++;
                                }
                        }
                }

        }*/

        public static int[] countNonDivisible(int[] tab){
                int[] tabResult=new int[tab.length];
                for(int i=0;i<tab.length;i++){
                        int count=0;
                        for(int j=0;j<tab.length;j++){
                                if(i==j);
                                else{
                                        if(tab[i]%tab[j]!=0){
                                                count++;
                                        }
                                }
                        }
                        tabResult[i]=count;
                }
                return tabResult;
        }

        public static int solutionLinkedList(int[] A, int[] B) {
                LinkedList<Integer> listOfPower=new LinkedList<>();
                LinkedList<Integer> listOfDirection=new LinkedList<>();

                for(int i=0; i<A.length;i++){
                        listOfPower.add(Integer.valueOf(A[i]));
                        listOfDirection.add(Integer.valueOf(B[i]));
                }
                int count=0;
                while(listOfPower.size()!=0){
                        if((Integer)listOfDirection.getFirst()==0){
                                listOfPower.removeFirst();
                                listOfDirection.removeFirst();
                                count++;

                        }
                        else if((int)listOfDirection.getLast()==1){
                                listOfPower.removeLast();
                                listOfDirection.removeLast();
                                count++;
                                System.out.println("Down! "+count);
                        }else{

                                for(int i=0;i<listOfPower.size()-1;i++){
                                        if((int)listOfDirection.get(i)==1 && (int)listOfDirection.get(i+1)==0 ){
                                                System.out.println("srodek");
                                                if((int)listOfPower.get(i)>(int)listOfPower.get(i+1)){
                                                        System.out.println("srodek 2");
                                                        listOfPower.remove(i+1);
                                                        listOfDirection.remove(i+1);
                                                        System.out.println(listOfDirection);
                                                        System.out.println(listOfPower);

                                                }else{
                                                        listOfPower.remove(i);
                                                        listOfDirection.remove(i);
                                                        System.out.println(listOfDirection);
                                                        System.out.println(listOfPower);
                                                }
                                                break;
                                        }
                                }

                        }
                }
                return count;


        }

        public static int solutionStringCorecct(String S) {
                char[] charArray=S.toCharArray();
                boolean isCorrect=true;
                for(int i=0; i<charArray.length/2;i++){
                       // System.out.println(charArray[i]+" "+charArray[charArray.length-i-1]);
                        if(charArray[i]=='{'){
                                if(charArray[charArray.length-i-1]!='}'){
                                        isCorrect=false;
                                }
                        }
                        else if(charArray[i]=='('){
                                if(charArray[charArray.length-i-1]!=')'){
                                        isCorrect=false;
                                }
                        }
                        else if(charArray[i]=='['){
                                if(charArray[charArray.length-i-1]!=']'){
                                        isCorrect=false;
                                }
                        }
                }
                if(charArray.length%2!=0){
                        return 0;
                }else if(isCorrect){
                        return 1;
                }else{
                        return 0;
                }
        }

        public static int solutionMultiple(int[] A) {
                Arrays.sort(A);
                int multpile=1;
                for(int i=A.length-3;i<A.length;i++){
                        multpile*=A[i];
                }

                return multpile;

        }
        public int solutionDiscs(int[] A) {
                int count=0;
                for(int i=0;i<A.length;i++){
                        for(int j=i;j<A.length;j++){
                                if((A[i]-i>A[j]-j && A[i]+i<A[j]+j) || (A[i]-i<A[j]-j && A[i]+i>A[j]-j)){
                                        count++;
                                }
                        }
                }
                return count;
        }

        public static int solutionDistinct(int[] A) {
                List<Integer> lista=new ArrayList<Integer>(A.length);
                for(int el:A){
                        lista.add(Integer.valueOf(el));
                }
                Set<Integer> set= new HashSet<>(lista);

                return set.size();
        }

        public static int[] solutionDNA(String S, int[] P, int[] Q) {
                char[] charArray=S.toCharArray();
                int[] tabResult=new int[P.length];
                int min;
                for(int i=0;i<P.length;i++){
                        min=4;
                        for(int j=P[i];j<=Q[i];j++){
                                if(charArray[j]=='A'){
                                        min=1;
                                }else if(charArray[j]=='C' && min>2){
                                        min=2;
                                }else if(charArray[j]=='G' && min>3){
                                        min=3;
                                }else if(charArray[j]=='T' && min==4){
                                        min=4;
                                }
                        }
                        tabResult[i]=min;
                }
                return  tabResult;
        }

        public static int solutionOfCarPairs(int[] A) {
                int first=A[0],next;
                if(first==0){
                     next=1;
                }else{
                        next=0;
                }
                int sumOfPair=0;
                int multiple=1;
                for(int i=1;i<A.length;i++){
                        if(A[i]==next){
                                sumOfPair+=multiple*1;
                        }else{
                                multiple++;
                        }
                }

                return sumOfPair;

        }

        public static int[] solutionOperations(int N, int[] A) {
             int[] tab=new int[N];

             for(int i=0;i<A.length;i++){
                     if(A[i]==N+1){
                             int max=Integer.MIN_VALUE;
                             for(int el: tab){
                                     if(el>max)max=el;
                             }
                             for(int j=0;j<tab.length;j++){
                                     tab[j]=max;
                             }
                     }
                     else{
                             tab[A[i]-1]++;
                     }
             }

             return tab;
        }

        public int smallestPositiveInteger(int[] A) {
                Arrays.sort(A);
                if(A[A.length-1]<=0){
                        return 1;
                }
                else{
                        ArrayList<Integer>listOfPositive=new ArrayList<>();
                        for(int el: A){
                                if(el>0 && listOfPositive.contains(el)==false){
                                        listOfPositive.add(el);
                                }
                        }
                        if(listOfPositive.get(0)!=1){
                                return 1;
                        }
                        else if(listOfPositive.size()==1){
                                return 1;
                        }else{
                                int i;
                                for(i=0;i<listOfPositive.size();i++){
                                        if( listOfPositive.get(i)!=listOfPositive.get(i+1)-1){
                                                break;
                                        }
                                }
                                return listOfPositive.get(i)+1;
                        }
                }


        }

        public static int solutionFrog(int X, int[] A) {
                int[] tmp=new int[X];
                for(int i=0; i<A.length;i++){
                        if(tmp[A[i]-1]==0){
                                tmp[A[i]-1]=i;
                        }
                }
                Arrays.sort(tmp);
                if(tmp[0]==0){
                        return -1;
                }else{
                        return tmp[X-1];
                }
        }

        public static int ifArrayIsPermutation(int tab[]){
                Arrays.sort(tab);
                int result=1;
                if(tab[0]!=1) return 0;
                for(int first=0;first<tab.length-1;first++){
                        if(tab[first]!=tab[first+1]-1){
                                result=tab[first]+1;
                        }
                }
                return result;
        }

        public static int minimalDeifferenceInArrayParts(int[] array){
                int sum=0;
                for(int el: array){
                        sum+=el;
                }
                int min=Integer.MAX_VALUE;
                int sumOfFirstPart=0;
                for(int i=0; i<array.length; i++){
                    sum-=array[i];
                    sumOfFirstPart+=array[i];
                    if((Math.abs(sumOfFirstPart-sum)<min)){
                            min=Math.abs(sumOfFirstPart-sum);
                    }
                }
                return min;
        }

        public static int sortArrayAndFindMissing(int tab[]){
                Arrays.sort(tab);
                int element=0;
                for(int first=0;first<tab.length-1;first++){
                        if(tab[first]!=tab[first+1]-1){
                                element=tab[first]+1;
                        }
                }
                return element;
        }

        public static int[] solution3(int[] tab, int K) {
                int step;
                if(K>tab.length){
                        step=K%tab.length;
                }
                else{ step=K;}

                int[] tmp=new int[tab.length+step];
                for(int j=0;j<step;j++){
                        tmp[j]=tab[step+j-1];
                }
                for(int i=0;i<tab.length;i++){
                        tmp[i+step]=tab[i];
                }

                int[] tmpFinal=new int[tab.length];
                for(int z=0;z<tmpFinal.length;z++){
                        tmpFinal[z]=tmp[z];
                }
                return tmpFinal;
        }

        public static int solutionBrakJednejWtablicy(int[] A){

                Map<Integer,Integer> mapOfQuantity=new HashMap<>();

                for(int i=0;i<A.length;i++){
                        if(mapOfQuantity.containsKey(A[i])){
                                int j=mapOfQuantity.get(A[i]);
                                j++;
                                mapOfQuantity.remove(A[i]);
                                mapOfQuantity.put(A[i],j);
                        }
                        else{
                                mapOfQuantity.put(A[i],1);
                        }

                }
                int value=Integer.MAX_VALUE;
                int index=0;
                for (Map.Entry<Integer,Integer> entry : mapOfQuantity.entrySet())
                {
                        if(value>entry.getValue()){
                                value=entry.getValue();
                                index=entry.getKey();
                        }
                }
                return index;
        }

        public static int solution(int N) {
                String binaryN=Integer.toBinaryString(N);
                char[] charArray=binaryN.toCharArray();
                ArrayList<Integer> listOfOne=new ArrayList<Integer>();
                for(int i=0; i<charArray.length; i++){
                        if(charArray[i]=='1'){
                                listOfOne.add(i);
                        }
                }

                int max=0;
                if(listOfOne.size()!=1 && listOfOne.size()!=0){
                        for(int i=0;i<listOfOne.size()-1;i++){
                                int zera=listOfOne.get(i+1)-listOfOne.get(i);
                                if(zera-1>max){
                                        max=zera-1;

                                }
                        }
                }

                return max;
        }

        public static void moveInTab(int[] tab,int K){
                int step;
                if(K>tab.length){
                        step=tab.length%K;
                }
                else{
                        step=K;
                }

             int[] tab2=new int[tab.length*2];
             int[] tabFinal=new int[tab.length];

             for(int y=0; y<tab.length*2;y++){
                     int index=y%tab.length;
                     tab2[y]=tab[index];
             }
                //System.out.println(step);
             for(int i=step;i<tab.length+step;i++){
                int index=(i-step)%tab.length;
                tabFinal[index]=tab2[i];
             }

             for(int i:tabFinal){
                     System.out.println(i);
             }
        }

        public static int frogJumps(int x, int y , int z){
                if ((z-x)%y!=0){
                        return ((z-x)/y)+1;
                }else{
                        return ((z-x)/y);
                }
        }

        public static void namesPlusQuantity(String[] names){

                ArrayList<String> arrayListOfNames=new ArrayList<>();
                Map<String, Integer> namesMap=new HashMap<>();
                for(String name: names){
                   if(namesMap.containsKey(name)){
                           int liczba=namesMap.get(name)+1;
                           String liczbaString=String.valueOf(liczba);

                           namesMap.remove(name);
                           namesMap.put(name,liczba);
                           String nameF=name+liczbaString;
                           arrayListOfNames.add(nameF);
                   }
                   else{
                           namesMap.put(name,0);
                           arrayListOfNames.add(name);
                   }
                }

                String[] finalTab= arrayListOfNames.toArray(new String[arrayListOfNames.size()]);
                for(String s: finalTab){
                        System.out.println(s);
                }
        }

        public static void namesInTab(String[] tab){
                Map<String, Integer>  namesQuantity=new HashMap<>();

                for(String name: tab){
                        if(namesQuantity.containsKey(name)){
                                int quantity=namesQuantity.get(name);
                                quantity++;
                                namesQuantity.remove(name);
                                namesQuantity.put(name,quantity);
                        }
                        else{
                                namesQuantity.put(name,1);
                        }
                }

                Set<String> names=namesQuantity.keySet();
                for(String name: names){
                        System.out.println(name+" is in tab times: "+namesQuantity.get(name));
                }

        }
}
