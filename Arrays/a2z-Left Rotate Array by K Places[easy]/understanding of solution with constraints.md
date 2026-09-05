## Constraint 1: `1 <= nums.length <= 10^5`

**Iska matlab:** Array mein **kam se kam 1 aur zyada se zyada 1,00,000 (1 lakh)** numbers ho sakte hain.

**Ye pichhle "Largest Element" wale constraint se bahut alag hai** (jaha `nums.length <= 100` tha). Yaha `10^5` (1 lakh) hai — matlab array **bahut bada** ho sakta hai.

**Isse pata kya chalta hai — konsi approach chalegi?**

Yaad karo humari table:
```
n <= 10^5  →  O(n) ya O(n log n) approach chahiye, O(n²) NAHI chalega
```

Agar tum `nums.length = 100000` pe **O(n²)** approach lagate (jaise do nested loops), toh:
```
100000 × 100000 = 10,000,000,000 (10 arab operations!)
```
Ye computer ke liye **bahut zyada** hai 1 second mein karne ke liye — TIME LIMIT EXCEEDED ho jayega.

**Humara jo solution hai (ek loop se numbers ko naye index pe rakhna, phir doosre loop se copy karna) — ye O(n) hai** (do alag loops hain, par dono independent hain, ek doosre ke andar nested nahi) — matlab total kaam `n + n = 2n` hota hai, jo **O(n)** hi kehlata hai. **Isliye ye approach yaha safe hai, bade array ke liye bhi fast chalega.**

## Constraint 2: `-10^4 <= nums[i] <= 10^4`

**Iska matlab:** Array ke andar jo actual **numbers (values)** hain, wo `-10,000` se `10,000` ke beech honge.

**Ye batata hai:**
1. **Negative numbers allowed hain** (minus sign dikh raha hai `-10^4`) — par is particular question mein ye **directly kaam nahi aata**, kyunki hum sirf **indices** ke saath kaam kar rahe hain (rotate karne ke liye), values ke saath koi calculation nahi kar rahe. Values chahe kuch bhi hon (`-10000` ho ya `10000`), humara code unhe bas **ek jagah se doosri jagah move** kar raha hai — values ko khud padhkar koi decision nahi le rahe.

2. Isliye is constraint ka is question mein **koi special impact nahi hai** approach pe — bas itna pata chal gaya ki array mein kaisi values ho sakti hain, in case tumhe kabhi values pe bhi kuch calculate karna pade.

> **Tip:** Har constraint har question mein "actionable" nahi hoti. Kabhi kabhi wo sirf ye batati hai ki values kis range mein hain, edge cases samajhne ke liye — jaise agar koi question hota "sabse bada number dhoondo" toh ye constraint bahut important hoti (negative se bachne ke liye `Integer.MIN_VALUE` use karte). Par "rotate array" mein hum values ko touch hi nahi kar rahe, sirf unki **jagah** badal rahe hain.

## Constraint 3: `0 <= k <= 105`
Chalo bilkul chhote numbers se, ek dum slow samjhata hoon. Code bhool jao abhi, sirf ek chhota sa real-life jaisa example lete hain.

## Ek Chhoti Si Ghadi Jaisi Cheez Socho

Maan lo tumhare paas sirf **5 numbered boxes hain, gol chakkar mein rakhe hue** (jaise ghadi):

```
        0
    4       1

    3       2
```

Ye box array jaisa hai, `nums.length = 5`.

## `k` Kya Hai — Simple Words Mein

`k` batata hai — **"kitni baar ghumana hai"**. Jaise agar `k=1`, matlab 1 baar ghumao. `k=2` matlab 2 baar ghumao.

## Ab Socho `k = 5` Ho (Yani Array Ke Size Ke Barabar)

Agar tum apne 5 boxes ko **poore 5 baar** ghumao, toh kya hoga?

Socho khud haath se karke dekho — box `0` ko ek jagah aage khisकाओ 5 baar:

```
Start:        0 1 2 3 4
1 baar ghumao: 4 0 1 2 3
2 baar ghumao: 3 4 0 1 2
3 baar ghumao: 2 3 4 0 1
4 baar ghumao: 1 2 3 4 0
5 baar ghumao: 0 1 2 3 4   ← WAPAS SHURU JAISA HI!
```

**Dekha?** 5 baar ghumane ke baad, array **bilkul waisa hi ban gaya jaisa shuru mein tha!** Matlab `k=5` karna, aur `k=0` karna (kuch bhi na karna) — **dono ka result SAME hai.**

## Ab Iska Fayda Samjho

Agar `k = 5` ho, aur array ka size bhi `5` ho, toh humein **poore 5 baar ghumane ki mehnat karne ki zarurat hi nahi hai** — kyunki result toh wahi aayega jo shuru mein tha! Hum seedha keh sakte hain "kuch mat karo" (`k=0` jaisa treat karo), aur wahi answer milega, bina extra kaam kiye.

## Ab Bade Number Pe Try Karo — `k = 7`, Array Size `5`

Socho `k = 7` hai, par array mein sirf `5` boxes hain. Tum `7` baar kaise ghumaoge jab pura chakkar sirf `5` mein hi complete ho jaata hai?

```
5 baar ghumane ke baad → array WAPAS SHURU jaisa (jaise humne abhi dekha)
Fir 2 aur baar ghumao (kyunki 7 - 5 = 2 bache) → jaise sirf k=2 kiya ho
```

**Matlab `k=7` karna, aur `k=2` karna — dono ka EXACT SAME result aayega!** (Kyunki pehle 5 rotations "waste" ho gaye — array wapas shuru jaisa ban gaya, sirf baaki 2 hi matter karte hain.)

## Yehi Cheez `%` Nikal Ke Deta Hai

Yaad hai `%` ka matlab — **"divide karo, jo bacha (remainder) wahi batao"**?

```
7 % 5 = ?
7 ÷ 5 = 1 baar poora hota hai (1×5=5), 2 bacha
7 % 5 = 2
```

**Dekho — `7 % 5` bhi `2` de raha hai!** Bilkul wahi number jo humne manually nikala tha (ki `k=7` asal mein `k=2` jaisa hi hai).

**Isi wajah se hum code mein `k = k % nums.length` likhte hain** — taaki agar `k` bahut bada number ho (jaise 7, ya 100, ya 100000), computer khud-ba-khud pata laga le **"asal mein kitni baar ghumana hai"** — bina waste rotations kiye.

## Ab Constraint Pe Wapas Aate Hain

```
0 <= k <= 10^5
```

Iska matlab: `k` **`0` se lekar `1,00,000` tak** kuch bhi ho sakta hai.

Par array ka size (`nums.length`) sirf **`1` se `1,00,000` tak** hai — matlab **`k` array size se bahut zyada bada ho sakta hai.**

**Example:** Socho array mein sirf `5` numbers hain, par `k = 1,00,000` diya gaya hai.

Agar tum seedha `1,00,000` baar ghumane ki calculation karo (bina `%` ke), toh bahut zyada unnecessary kaam hoga (jabki asal mein sirf kuch hi rotations matter karte hain — baaki sab "wasted full circles" hain, jo koi fark hi nahi daalte).

**Isliye shuru mein hi likhte hain:**
```java
k = k % nums.length;
```

Isse `k` turant **chhota, sahi number** ban jaata hai — jitni baar **asal mein** ghumana hai, utna hi. Baaki sab "extra pura chakkar" wale rotations discard ho jaate hain, kyunki unka koi effect hi nahi padta final answer pe.

## Ek Dum Simple Line Mein Yaad Rakho

**"Agar `k` array ke size se bada hai, toh usme se jitne bhi 'pure chakkar' (multiples of size) ban rahe hain, wo hata do — sirf jo bacha hai (remainder) wahi matter karta hai. Yehi kaam `%` karta hai."**

---

## Sabse Important Cheez Jo Is Constraint Se Seekhi

**Jab bhi tum dekho `k` (ya koi bhi "kitni baar karna hai" jaisa number) ka range, **array/list ke size se bada ho sakta hai**, turant socho — "isko `% n` se chhota banana padega, warna unnecessary bade loops/calculations honge."**

Ye ek bahut common pattern hai jo bahut saare "rotation/circular" wale questions mein aata hai — jab bhi "steps", "rotations", "k" jaisa parameter ho jo array size se bada ho sakta hai, **pehli line mein hi `k = k % n` kar lena.**

## Quick Summary Table

| Constraint | Kya Batata Hai | Is Question Mein Impact |
|---|---|---|
| `1 <= nums.length <= 10^5` | Array bada ho sakta hai | O(n) approach chahiye, O(n²) nahi chalega |
| `-10^4 <= nums[i] <= 10^4` | Values ka range | Is question mein directly use nahi hota (sirf indices se kaam hai) |
| `0 <= k <= 10^5` | `k`, array size se bhi bada ho sakta hai | Shuru mein `k = k % n` zaroor karo |

Achha sawaal — chalo ek list banate hain, taaki jab bhi koi naya question mile, turant pehchan sako "yaha `%` lagega ya nahi".

## `%` (Modulo) Kab Kab Use Hota Hai — Poori List

### 1. **Circular / Wraparound Array Problems**

**Kab use karna hai:** Jab array ko **gol chakkar (circle)** ki tarah treat karna ho — matlab last element ke baad wapas first element aa jaaye.

**Pehchan kaise karo:** Question mein ye words dikhein — "rotate", "circular", "wraparound", "after the last element, go back to first"

**Examples jo humne kiye:**
- Rotate Array by K (left/right)
- Check if Array is Sorted and Rotated
- Left Rotate Array by One

**Formula pattern:**
```java
nums[(i + 1) % n]        // next index, wraparound ke saath
nums[(i - 1 + n) % n]    // previous index, negative se bachte hue
```

### 2. **`k` Ko Chhota Banane Ke Liye (Jab k, Size Se Bada Ho Sakta Ho)**

**Kab use karna hai:** Jab koi parameter (`k`, `steps`, `rotations`) di gayi ho jo **array/list ke size se bada ho sakta ho**.

**Pehchan kaise karo:** Constraint mein dekho — agar `k` ka max range, `n` (size) ke max range se bada ya barabar ho sakta hai.

**Example:** Rotate Array — `k = k % n` (jo humne abhi discuss kiya)

### 3. **Hashing / Distributing Items Into Buckets**

**Kab use karna hai:** Jab tumhe numbers ko **fixed sankhya ke "buckets" ya "groups"** mein daalna ho.

**Example:** Agar tumhe numbers ko unke **last digit** ke hisaab se group karna ho:
```java
int bucket = num % 10;   // last digit hi bucket number ban jaata hai (0-9)
```

Ya agar tumhe `n` buckets mein items evenly distribute karne hain:
```java
int bucketIndex = item % n;
```

### 4. **Even/Odd Check Karna**

**Kab use karna hai:** Kisi number ke even/odd hone ka pata lagana.

```java
if (num % 2 == 0) {
    // even hai
} else {
    // odd hai
}
```

**Ye bhi ek chhota "modulo" application hai** — kyunki `% 2` sirf `0` ya `1` de sakta hai, aur ye batata hai number "2 ka group" poora banata hai ya nahi.

### 5. **Digit Extract Karna (Numbers Ke Andar Se)**

**Kab use karna hai:** Kisi number ka **aakhri digit** nikaalna ho.

```java
int lastDigit = num % 10;   // jaise 4567 % 10 = 7
```

Ye tab kaam aata hai jab tumhe number ko digit-by-digit process karna ho (jaise "reverse a number", "sum of digits" jaise questions).

### 6. **Cyclic Patterns / Repeating Sequences**

**Kab use karna hai:** Jab koi pattern **baar baar repeat** hota ho, aur tumhe pata karna ho ki `nth` position pe kya aayega.

**Example:** "Agar `[R, G, B]` colors repeat ho rahe hain, toh 100th position pe konsa color hoga?"
```java
int position = 100 % 3;   // 3 colors hain, toh cycle length 3 hai
```

### 7. **Large Number Ko "Wrap" Karna (Overflow Se Bachne Ke Liye)**

**Kab use karna hai:** Competitive programming mein jab answer bahut bada ho sakta ho, aur tumse kaha jaaye **"answer ko `10^9 + 7` se modulo karke do."**

```java
int answer = (bigCalculation) % 1000000007;
```

Ye thoda advanced hai, abhi tumhe iski zarurat nahi padegi, par aage jaake DP/combinatorics wale questions mein dikhega.

## Simple Trick — Kaise Pehchano Ki `%` Chahiye Ya Nahi

Jab bhi koi naya question mile, khud se ye sawaal pucho:

### Sawaal 1: "Kya koi index/number, array ke size se BAHAR ja sakta hai?"
Agar haan → `% n` use karo taaki wo wapas valid range (0 se n-1) mein aa jaaye.

### Sawaal 2: "Kya array ko circle/gol chakkar ki tarah treat karna hai?"
Agar haan (jaise "last element ke baad first element aata hai") → `%` zaroor lagega.

### Sawaal 3: "Kya mujhe kisi number ka sirf 'chhota version' chahiye, jo ek fixed range mein rahe?"
Jaise `k` ko `0` se `n-1` ke beech laana, ya kisi number ko `0-9` ke beech laana (digit ke liye) → `%` use hoga.

## Bahut Important Cheez — `%` Ka Result Hamesha Kya Deta Hai

Yaad rakho: **`x % n` ka result hamesha `0` se `n-1` ke beech hi aata hai** (Java mein negative `x` ke case ko chhodkar, jaha `+n` bhi jodna padta hai). 

**Isliye jab bhi tumhe koi number "ek fixed range ke andar wapas laana" ho, `%` sabse pehla tool hai jo dimag mein aana chahiye.**

## Quick Reference Table (Save Kar Lo)

| Situation | Formula Pattern | Example Question |
|---|---|---|
| Next index, circular array | `(i+1) % n` | Rotate array, Check rotated sorted |
| Previous index, circular array | `(i-1+n) % n` | Left rotate by one |
| `k` ko size se chhota banao | `k % n` | Rotate by k places |
| Last digit nikaalo | `num % 10` | Reverse a number |
| Even/odd check | `num % 2` | Any parity check question |
| Bucket/group banao | `item % numBuckets` | Hashing |
| Cyclic pattern ka nth position | `n % cycleLength` | Repeating pattern questions |

---
