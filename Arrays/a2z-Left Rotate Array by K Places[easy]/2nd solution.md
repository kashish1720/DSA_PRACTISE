Koi baat nahi, bilkul zero se samjhate hain. Code bhool jao, pehle sirf **haath se** samjho ki ho kya raha hai.

## Real-life example se samjho

Socho tumhare paas 7 kursiyon ki ek line hai, unpe baithe hain logo ke number tags:

```
Position:  0  1  2  3  4  5  6
Log:       1  2  3  4  5  6  7
```

Tumhe **left rotate by 3** karna hai — matlab pehle 3 log (1, 2, 3) line ke **sabse peeche** chale jaayenge, aur baaki log (4, 5, 6, 7) **aage** khisak jaayenge.

Final result hona chahiye:
```
Position:  0  1  2  3  4  5  6
Log:       4  5  6  7  1  2  3
```

Ab sawaal ye hai — ye karein kaise? Striver 3 chhote steps mein karte hain.

---

## Step 1: Peeche jaane waalon ko side mein bula lo (temp mein)

Jo log 1, 2, 3 peeche jaane waale hain, unko pehle **line se nikal ke ek side mein khada kar do** (isko hum "temp" bulate hain, matlab "temporary jagah, thodi der ke liye")

```
Temp (side mein khade):  [1, 2, 3]
```

**Kyun?** Kyunki agar hum inko side mein nahi karenge, toh jab hum baaki logo ko aage khiskayenge, ye log kho jaayenge — unka data overwrite ho jaayega. Isliye pehle inhe "bacha" liya, safe jagah pe.

---

## Step 2: Baaki logo ko aage khisका do

Ab line mein sirf 4, 5, 6, 7 bache hain (soch lo 1,2,3 waali kursiyan khaali hain abhi). Inhe seedha **aage wali khaali kursiyon** pe la do:

```
Pehle:     _  _  _  4  5  6  7
Ab:        4  5  6  7  _  _  _
```

4 pehli kursi pe aa gaya, 5 dusri pe, 6 teesri pe, 7 chauthi pe. Baaki 3 kursiyan (position 4,5,6) abhi khaali hain.

---

## Step 3: Side mein khade logo (temp) ko wapas line ke end mein bitha do

Ab jo log humne side mein khada kiya tha (1, 2, 3), unko line ki **khaali bachi hui kursiyon** (last 3) pe bitha do:

```
4  5  6  7  1  2  3
```

Aur bas! Yehi tumhara final answer hai. 🎉

---

## Toh recap — sirf 3 kaam hue:

1. **Jo peeche jaane hain unko side mein rakh do (temp)** — taaki wo kho na jaayein
2. **Baaki sabko aage khisका do** — unki nayi jagah pe
3. **Side waalon ko wapas end mein bitha do**

---

## Ab tumhara wala solution kaise alag tha?

Tumhare solution mein tumne **poori nayi 7 kursiyon ki line** banayi thi (result array), aur har banda seedha apni **final jagah** pe direct baith gaya tha — ek hi formula se calculate karke ki "mujhe kahan baithna hai".

Striver wale solution mein sirf **3 kursiyon jitni** ("d" jitni) side jagah use hui — poori nayi line nahi banayi. Isliye striver ka thoda kam jagah (memory) use karta hai.

Dono hi tarike sahi hain, bas jagah (memory) kitni use hoti hai — usme farak hai. Jo tarika kam extra jagah use kare, wo generally "better" mana jaata hai.

Time Complexity = O(n)
Teen loops hain:

Loop 1: k baar chalta hai (temp bharne ke liye)
Loop 2: n-k baar chalta hai (shift karne ke liye)
Loop 3: k baar chalta hai (temp wapas daalne ke liye)

Total = k + (n-k) + k = n + k. Lekin k hamesha n se chhota ya barabar hota hai (kyunki humne k = k % n kiya), toh worst case mein bhi ye O(n) hi rahega (constants drop karke).

Space Complexity = O(k)
Sirf ek extra array banaya: int[] temp = new int[k]; — iska size sirf k hai, poore n jitna nahi. Isliye extra space = O(k).

Aur agar k bahut chhota hai n ke comparison mein (jaise k=3, n=1000000), toh ye tumhare pehle wale solution (jo O(n) space leta tha) se kaafi better hai memory ke hisaab se.
