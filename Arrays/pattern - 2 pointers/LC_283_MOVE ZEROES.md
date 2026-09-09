Good question! Chalo dekhte hain.

`j = -1` ek **sentinel value** hai — matlab ek "flag" value jo batati hai ki "abhi tak kuch mila nahi hai". Isko tum kuch bhi le sakti ho, **bas ek condition honi chahiye**: wo value **valid array index na ho** (0 se n-1 ke beech na ho), taaki tum easily check kar sako "zero mila ya nahi".

**Kya-kya use kar sakti ho:**

```java
int j = -1;   // ✅ best choice - kabhi bhi valid index nahi hota
int j = -100; // ✅ ye bhi chalega, kyunki negative hai
int j = n;    // ✅ ye bhi chalega (array size ke bahar hai)
```

**Kya nahi use kar sakti:**

```java
int j = 0;    // ❌ galat - ye ek valid index hai (pehla element)
int j = 5;    // ❌ agar array chhota hai to out of bounds error de sakta hai, 
              //     aur agar bada hai to wrongly ek valid index maan lega
```

**Kyun `-1` sabse best hai:**
1. Ye **kabhi bhi** valid array index nahi ho sakta (array index hamesha 0 se start hota hai)
2. Check karna easy hai: `if(j == -1)` — clearly matlab "kuch mila nahi"
3. Convention bhi yahi hai — Java/C++ me `-1` ka use hota hai "not found" dikhane ke liye (jaise `indexOf()` method bhi `-1` return karta hai jab element na mile)

**Simple rule:** Sentinel value aisi honi chahiye jo **normal case me kabhi na aaye**, taaki tum use safely "flag" ki tarah check kar sako. `-1` isliye perfect hai kyunki array index kabhi negative nahi hota.
