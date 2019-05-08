# merge sorted lists

The lists are stored
[contiguously](https://www.merriam-webster.com/dictionary/contiguous)
in a piece of an ArrayList, specified by
the indexes at their boundaries.

For example, here is a picture of the two 
sorted lists of card values
that we merged in class on Wednesday 2019-05-08, 
preceded by 2 positions whose values are to be ignored,
and followed by 3 positions whose values are to be ignored.
The values to be ignored are represented here by `_`.
```
values:  _ _ "4" "5" "6" "9" "2" "3" "4" "6" "7" "J" "Q" "K" _  _  _
indexes: 0 1  2   3   4   5   6   7   8   9   10  11  12  13 14 15 16 
```
The boundaries (check my counting!) are represented
with [half-open intervals](https://en.wikipedia.org/wiki/Interval_(mathematics)#Terminology):
* list0 starts at index 2 with the String value `"4"`
* list1 starts at index 6 with the String value `"2"`. 
Since the lists are "stored contiguously", that 6 also 
marks the position just past the end of list0.
The last value in list0 is therefore `"9"`.
* list1 ends just before index 14, with a last value
of `"K"`.

The resulting, merged list is to occupy the original range.
In the example above that means the interval `[2,14)`.

We need not merge *in place*.
(Doing so is apparently complicated.)
So start your merge procedure by allocating storage to hold 
a copy of the data. Copy the data, then
merge from the copy into the range whence it arrived.

>You are of course welcome to look into in-place merges.
But get this merge working first.
