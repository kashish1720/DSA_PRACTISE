Real life example se samjho (bina code ke pehle)

Socho tumhare paas ek rassi hai jispe 7 log baithe hain, haath pakड़ke:

1 - 2 - 3 - 4 - 5 - 6 - 7

Tumhe left rotate by 3 karna hai, result chahiye:

4 - 5 - 6 - 7 - 1 - 2 - 3

Ab magic trick ye hai — agar tum kisi bhi group ko ulta (reverse) kar do, toh unki relative position badal jaati hai but pattern interesting hota hai. Striver ne discover kiya ki agar tum 3 baar reverse karo sahi jagah pe, toh answer khud hi aa jaata hai!

3 Steps (dhyan se dekho)

Step 1: Pehle k elements ko ulta karo (reverse)

[1, 2, 3] ko reverse karo → [3, 2, 1]

Poora array ab: [3, 2, 1, 4, 5, 6, 7]

Step 2: Baaki (k se n tak) elements ko ulta karo

[4, 5, 6, 7] ko reverse karo → [7, 6, 5, 4]

Poora array ab: [3, 2, 1, 7, 6, 5, 4]

Step 3: Ab POORE array ko ulta karo

[3, 2, 1, 7, 6, 5, 4] → poora reverse karo → [4, 5, 6, 7, 1, 2, 3]

🎉 Dekho ye tumhara final answer hai!
Ye kaam kyun karta hai (intuition)

Ye thoda counter-intuitive lagta hai, isliye ek simple tareeke se socho:

Jab tum kisi group ko reverse karte ho do baar (pehle apne andar-andar, phir dono groups ko saath mein), toh unka andar ka order wapas sahi ho jaata hai, lekin unki jagah (position) badal jaati hai.

Socho aise: agar tumhe do cheezein A (jo 1,2,3 hai) aur B (jo 4,5,6,7 hai) ka order A-B se B-A karna hai (bina unke andar ka order bigade), toh trick hai:

A ko reverse karo → A'
B ko reverse karo → B'
A' + B' ko poora reverse karo → B + A ban jaata hai!

Ye ek standard trick hai jab bhi tumhe do blocks ka order swap karna ho bina unke andar ka sequence bigade.

Code kaise likhoge

Tumhe bas ek helper function chahiye jo do indexes ke beech ka portion reverse kare:

java
class Solution {
    public void rotateArray(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        
        reverse(nums, 0, k - 1);      // Step 1: pehle k elements
        reverse(nums, k, n - 1);      // Step 2: baaki elements
        reverse(nums, 0, n - 1);      // Step 3: poora array
    }
    
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
Complexity
Time Complexity: O(2n) ≈ O(n) — teeno reverse operations mila ke total elements jitni baar touch hote hain roughly 2n baar (chhoti details ignore karke)
Space Complexity: O(1) — koi bhi naya array nahi banaya! Sirf ek temp variable use hua swap ke liye. Ye sabse best hai kyunki bilkul extra memory nahi li.

🔑 Future ke liye Tips & Tricks (General Pattern Recognition)

Ye wali cheezein yaad rakhoge toh aise problems khud solve kar paoge:

1. Jab bhi "rotate" ya "reorder two blocks" wala problem dikhe, socho:

"Kya main isko 3-reverse trick se solve kar sakta hoon?" (Reverse part1, reverse part2, reverse poora)

2. O(1) space ka matlab hamesha hota hai:

"Naya array ya list mat banao — jo diya hai usी mein swap/reverse karke kaam karo."

3. Reverse helper function ek reusable tool hai:

Jab bhi kahin "reverse a portion of array" chahiye ho, ye function bana lo aur bar bar use karo — ye bahut common building block hai (isko interviews mein bhi bar bar use karte hain).

4. Complexity ka pattern samajho:

Agar tumhare paas 3 chhote loops/operations hain jo har element ko ek-ek baar touch karte hain (chahe alag-alag jagah pe), toh total time still O(n) hi rahega — bas constant factor thoda badhta hai (2n, 3n etc.), jo Big-O mein matter nahi karta.

5. Practice karne ka tarika:

Jab bhi koi naya pattern dikhe (jaise ye reversal wala), usko kaagaz pe manually 2-3 example se chalao (jaise humne abhi kiya) — jab tak haath se na samjho, dimaag mein "click" nahi hota. Code baad mein aata hai, samajh pehle aani chahiye.

Bahut badhiya trick hai ye — agar ache se samajh liya toh similar array manipulation problems (jaise "swap two halves", "reverse in groups") bhi aasani se solve kar paoge! 🚀

Sabse pehle: reverse function kya kaam karta hai

Ye chhota function samjho pehle, kyunki poora solution isी pe based hai.

java
private void reverse(int[] nums, int start, int end) {
    while (start < end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        start++;
        end--;
    }
}

Ye kya karta hai? Ismein tum bolte ho: "array nums mein, start index se lekar end index tak jo bhi hai, use ulta kar do."

Example se dekho: reverse(nums, 0, 3) jab nums = [4, 5, 6, 7]
Index:    0  1  2  3
nums:     4  5  6  7
start=0 ↑           ↑ end=3

Iteration 1:

temp = nums[0] → temp = 4 (4 ko yaad kar liya, kho na jaaye isliye)
nums[0] = nums[3] → nums[0] = 7 (position 3 wala, position 0 pe daal diya)
nums[3] = temp → nums[3] = 4 (jo yaad kiya tha, wo end pe daal diya)
Index:    0  1  2  3
nums:     7  5  6  4
start++ → start = 1
end-- → end = 2

Iteration 2: (ab start=1, end=2)

temp = nums[1] → temp = 5
nums[1] = nums[2] → nums[1] = 6
nums[2] = temp → nums[2] = 5
Index:    0  1  2  3
nums:     7  6  5  4
start++ → start = 2
end-- → end = 1

Ab start (2) < end (1) false hai, toh loop ruk jaata hai.

Final result: [7, 6, 5, 4] — bilkul ulta ho gaya original [4,5,6,7] se! 🎉

Simple bhasha mein samjho: ye function do logo ko pakड़ke unki jagah swap karta hai — ek left se, ek right se — aur dono ek dusre ki taraf khisकते jaate hain jab tak beech mein mil na jaayein.

Ab poora solution samjho (isी reverse function ko 3 baar use karke)
java
public void rotateArray(int[] nums, int k) {
    int n = nums.length;
    k = k % n;
    
    reverse(nums, 0, k - 1);
    reverse(nums, k, n - 1);
    reverse(nums, 0, n - 1);
}
Example: nums = [1, 2, 3, 4, 5, 6, 7], k = 3

n = 7, k = 3 (already chhota hai n se, toh k % n same rahega)

Line 1: reverse(nums, 0, k - 1) → reverse(nums, 0, 2)

Iska matlab: "index 0 se index 2 tak (yaani pehle 3 elements: 1, 2, 3) ko ulta kar do."

Pehle:    [1, 2, 3, 4, 5, 6, 7]
                ↓ reverse karo isko ↓
                [1, 2, 3]
                ↓
                [3, 2, 1]
Baad mein: [3, 2, 1, 4, 5, 6, 7]
Line 2: reverse(nums, k, n - 1) → reverse(nums, 3, 6)

Iska matlab: "index 3 se index 6 tak (yaani baaki elements: 4, 5, 6, 7) ko ulta kar do."

Pehle:    [3, 2, 1, 4, 5, 6, 7]
                      ↓ reverse karo isko ↓
                      [4, 5, 6, 7]
                      ↓
                      [7, 6, 5, 4]
Baad mein: [3, 2, 1, 7, 6, 5, 4]
Line 3: reverse(nums, 0, n - 1) → reverse(nums, 0, 6)

Iska matlab: "POORE array (index 0 se 6 tak) ko ulta kar do."

Pehle:    [3, 2, 1, 7, 6, 5, 4]
           ↓ poora reverse karo ↓
Baad mein: [4, 5, 6, 7, 1, 2, 3]
🎉 Ye tumhara final, sahi answer hai!
Visualization ek saath (poori journey dekho)
Original:        [1, 2, 3, 4, 5, 6, 7]

Step 1 (reverse pehle 3):
                  [3, 2, 1, 4, 5, 6, 7]
                   └──────┘
                   ye ulta hua

Step 2 (reverse baaki 4):
                  [3, 2, 1, 7, 6, 5, 4]
                            └────────┘
                            ye ulta hua

Step 3 (reverse poora):
                  [4, 5, 6, 7, 1, 2, 3]
                   └────────────────┘
                   POORA ulta hua

Final Answer:     [4, 5, 6, 7, 1, 2, 3] ✅
Simple bhasha mein "why it works" (bina maths ke)

Socho tumhare paas do groups hain:

Group A = 1, 2, 3 (jo peeche jaana hai)
Group B = 4, 5, 6, 7 (jo aage aana hai)

Tumhe chahiye: A B → B A (order swap, andar ka sequence same rahe)

Trick:

A ko ulta karo → A'
B ko ulta karo → B'
A' B' ko poora ulta karo → automatically B A ban jaata hai!

Kyun? Kyunki jab tum poora A'B' ulta karte ho, andar ka har element bhi wapas seedha ho jaata hai (double negative jaisa — ulta ka ulta seedha), aur saath hi groups ki jagah bhi swap ho jaati hai. Ye ek do birds one stone wala trick hai!

Yaad rakhne ka tarika (mnemonic)

"Chhota ulta, bada ulta, phir poora ulta"

Chhota part (k size) ulta karo
Bada part (baaki) ulta karo
Poora array ulta karo

Bas itna yaad rakhoge toh ye code kabhi nahi bhoologe. Agar кभी confuse ho jaao, ek kaagaz pe 5-6 numbers likhke haath se yeh 3 steps chala lena — turant clear ho jaayega.

Time Complexity: O(2n) ≈ O(n) — teeno reverse operations mila ke total elements jitni baar touch hote hain roughly 2n baar (chhoti details ignore karke)

nhi smjha

Chalo isko bhi numbers se samjhते hain, bilkul zero se.

Sawaal ye hai: teeno reverse mila ke kitna kaam hota hai?

Humara example tha: n = 7, k = 3

Teeno reverse calls dekho:

reverse(nums, 0, 2) → ye sirf 3 elements ko touch karta hai (1, 2, 3)
reverse(nums, 3, 6) → ye 4 elements ko touch karta hai (4, 5, 6, 7)
reverse(nums, 0, 6) → ye poore 7 elements ko touch karta hai
Ab ginte hain total kitna kaam hua
Step 1: 3 elements touch hue
Step 2: 4 elements touch hue
Step 3: 7 elements touch hue
─────────────────────────────
Total = 3 + 4 + 7 = 14 elements touch hue

Aur n = 7 tha. Toh 14 = 2 × 7 = 2n.

Interesting cheez dekho: Step 1 aur Step 2 mila ke bhi 3 + 4 = 7 elements touch hue — yaani poore array jitna hi (kyunki Step 1 aur 2 mil ke poore array ko cover karte hain, bas do tukdon mein). Fir Step 3 mein firse poora array (7 elements) touch hota hai.

Toh total hua: (poora array ek baar, do tukdon mein) + (poora array doosri baar, ek saath) = n + n = 2n

Simple bhasha mein samjho

Socho tumhe 7 kitabein uठाni hain, table se shelf tak.

Pehli baar tum unko 2 batches mein le jaate ho (3 kitabein ek trip mein, 4 kitabein doosri trip mein) — total 7 kitabein uठाई (ek-ek trip mila ke)
Phir tumhe wapas saari 7 kitabein firse uठाni padी (kisi aur kaam ke liye, jaise dobara sort karna)

Toh total kitabein uठाई = 7 (pehli baar) + 7 (doosri baar) = 14 baar uठाई, chahe kitabein sirf 7 hi thi.

Yehi wajah hai ki humara code, n elements ke liye, total 2n baar kaam karta hai — kyunki har element do baar touch hota hai poore process mein (ek baar apne chhote group ke reverse mein, ek baar final poore-array reverse mein).

Ab "Big-O" mein isko kyun O(n) bolte hain (na ki O(2n))

Jab array bahut bada ho jaata hai (jaise n = 1,000,000), tab farak nahi padता ki tumne n baar kaam kiya ya 2n baar — dono hi "linearly badhte hain" array ke size ke saath. Bas ek chhota sa constant multiplier (2) hai, jo hum Big-O mein ignore kar dete hain, kyunki hume sirf ye jaanna hai ki growth pattern kaisa hai (linear? quadratic? etc.), exact number nahi.

Isliye: O(2n) ko hum simplify karke sirf O(n) likhते hain.

Yaad rakhne ka simple rule

Big-O mein hum sirf ye dekhte hain ki input (n) badhne pe kaam kaise badhता hai — 2, 3, 5 jaise fixed numbers (constants) se multiply/divide hone se growth pattern nahi badalता, isliye unhe hata dete hain.

Jaise:

O(n) + O(n) = O(2n) = O(n) (constant hata diya)
O(n) + O(n) + O(n) = O(3n) = O(n) (yehi hamara case hai)
Lekin O(n) × O(n) = O(n²) — ye alag hai, kyunki yahan n khud se multiply ho raha hai, koi fixed number se nahi

