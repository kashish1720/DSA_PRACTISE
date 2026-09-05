class Solution {
    public void rotateArrayByOne(int[] nums) {
        int n = nums.length;
        int []result  = new int [n];
        for(int i = 0;i<n;i++){
            int newposition = ((i-1)+n)%n;
            result[newposition]= nums[i];
        }
        for(int i =0;i<n;i++){
            nums[i] = result[i];
        }
        
    }
}


/////question link - https://takeuforward.org/plus/dsa/problems/left-rotate-array-by-one?source=strivers-a2z-dsa-track

////tricks / solution undertsanding - 
/*Pehle Error Padhna Seekho
ArrayIndexOutOfBoundsException: Index -1 out of bounds for length 5

Matlab tumne index -1 access karne ki koshish ki. Array mein negative index jaisi cheez hoti hi nahi (indices hamesha 0 se shuru hote hain) — isliye crash ho gaya.

Kaha Se Aaya Ye -1

Tumhara code:

java
int newposition = (i-1) % n;

Jab i = 0 (loop ka pehla round), toh:

newposition = (0 - 1) % 5 = -1 % 5

Ab yaha ek bahut important cheez hai jo Java ke baare mein pata honi chahiye:

Java Mein % Negative Numbers Ke Saath Alag Behave Karta Hai!

Humne pehle seekha tha % "remainder" deta hai. Ye sahi hai positive numbers ke liye. Par jab number negative hota hai, Java ka % operator result ka sign, pehle number (dividend) jaisa hi rakhta hai.

5 % 3 = 2       (positive ÷ positive → positive result)
-1 % 5 = -1     (negative ÷ positive → NEGATIVE result!)
-7 % 5 = -2     (yaha bhi negative)

Ye Python jaisi languages se alag hai — Python mein -1 % 5 = 4 aata hai, par Java mein -1 % 5 = -1 hi aata hai. Isi wajah se tumhara code crash hua — % ne negative index wapas diya, jo array mein exist hi nahi karta.

Toh Ab Karein Kya
Sabse Pehle: Socho Chahiye Kya Tha

Tum left rotate kar rahe ho, matlab har number apni jagah se peeche (piche) ja raha hai, na ki aage. Isliye tumne -1 use kiya, jo sahi socha tha (concept sahi hai).

Par problem ye hai: jab result negative aa jaaye, use humein wapas positive banana padta hai, taaki wo ek valid index bane.

Trick: +n Jod Do Modulo Se Pehle
java
int newposition = ((i - 1) + n) % n;

Isse kya hota hai? Hum pehle n (array ka size) jod dete hain, taaki number kabhi negative na ho, uske baad % n lagate hain safe tarike se.

Dry Run Karke Dekho — i=0, n=5

Tumhara galat wala:

(0 - 1) % 5 = -1 % 5 = -1   ❌ (crash)

Fix wala:

((0 - 1) + 5) % 5 = (-1 + 5) % 5 = 4 % 5 = 4   ✓ (valid index)

Dekho — 4 ek valid index hai (0 se 4 tak array mein), koi crash nahi hoga.

Poora Fixed Code
java
class Solution {
    public void rotateArrayByOne(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int newposition = ((i - 1) + n) % n;
            result[newposition] = nums[i];
        }
        for (int i = 0; i < n; i++) {
            nums[i] = result[i];
        }
    }
}
Poora Dry Run Karo — nums = [1,2,3,4,5], n=5
i=0: nums[0]=1, nayi jagah = ((0-1)+5)%5 = 4%5 = 4 → result[4]=1
i=1: nums[1]=2, nayi jagah = ((1-1)+5)%5 = 5%5 = 0 → result[0]=2
i=2: nums[2]=3, nayi jagah = ((2-1)+5)%5 = 6%5 = 1 → result[1]=3
i=3: nums[3]=4, nayi jagah = ((3-1)+5)%5 = 7%5 = 2 → result[2]=4
i=4: nums[4]=5, nayi jagah = ((4-1)+5)%5 = 8%5 = 3 → result[3]=5

Final result:

index:  0  1  2  3  4
value:  2  3  4  5  1

result = [2, 3, 4, 5, 1]

Bilkul expected output se match ho gaya! ✅

Ab Tumhare "Turn" Wale Question Ka Answer

nums = [7, 6, 5, 4], n = 4

i=0: nums[0]=7, nayi jagah = ((0-1)+4)%4 = 3%4 = 3 → result[3]=7
i=1: nums[1]=6, nayi jagah = ((1-1)+4)%4 = 4%4 = 0 → result[0]=6
i=2: nums[2]=5, nayi jagah = ((2-1)+4)%4 = 5%4 = 1 → result[1]=5
i=3: nums[3]=4, nayi jagah = ((3-1)+4)%4 = 6%4 = 2 → result[2]=4

Final result:

index:  0  1  2  3
value:  6  5  4  7

result = [6, 5, 4, 7]

Answer: [6, 5, 4, 7] — options mein ye teesra wala hai.

Sabse Important Baat Yaad Rakho

Java mein % operator negative numbers ke saath negative result de sakta hai (unlike Python/kai languages). Jab bhi tumhe lage ki formula ka result negative aa sakta hai (jaise left rotate mein i-1), hamesha pehle +n jod do, uske baad % n lagao:

java
((kuch bhi negative ho sakta hai) + n) % n

Ye ek general trick hai jo har jagah kaam aayegi jaha bhi "peeche jaane" wala calculation ho (left rotate, circular array traversal jaha index ghat raha ho, etc).*/
