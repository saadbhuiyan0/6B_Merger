/**
  Represent a merge operation for sorted lists,
  as described in README.md
 */
import java.util.ArrayList;

public class Merger {

    ArrayList<String> usersData;
    ArrayList<String> mergedData;

    /**
      Construct an instance from a list of data
      part of which is to be merged. See README
     */
    public Merger( ArrayList<String> list) {
        usersData = list;
    }


    /**
      Merge the sorted sub-lists.
     */
    public void merge(
      // indexes of sub-list boundaries; see README
        int start0  // index of first item in list0
      , int start1  // index of first item in list1
                    // = just past end of list0
      , int nItems  // number of items in the merged list
                    // = just past end of list1
      ) {

        ArrayList<String> list1 = new ArrayList<String>();
        for ( int index = start0; index < start1; index++) {
          list1.add( usersData.get( index));
        }

        ArrayList<String> list2 = new ArrayList<String>();
        for ( int index = start1; index < nItems; index++) {
          list2.add( usersData.get (index));
        }
        
        merge( list1, list2);
        usersData = mergedData;
    }

    /**
      Merge the sorted sub-lists recursively.
      I haven't thought about while style much 
      but I always seem to struggle more with
      recursion.
     */
    public void merge( 
        ArrayList<String> list1, 
        ArrayList<String> list2
      ) {

        if ( !list1.isEmpty() && !list2.isEmpty()) {
          if ( list1.get( 0).compareTo( list2.get( 0)) < 1) {
            mergedData.add( list1.get( 0));
            list1.remove( 0);
            merge( list1, list2);
          } else {
            mergedData.add( list2.get( 0));
            list2.remove( 0);
            merge( list1, list2);
          }
        } 
        
        if ( !list1.isEmpty() && list2.isEmpty()) {
          merge( list1);
        } else {
          merge( list2);
        }
    }

    public void merge( ArrayList<String> notEmptyList) {
      for ( int index = 0; index < notEmptyList.size(); index++) {
        mergedData.add( notEmptyList.get( index));
      }
    }


    /**
      @return a string representation of the user's data
     */
    public String toString() {
        return "" + usersData; 
    }

    
    /** 
      @return the boolean value of the statement
         "the data in the range are in ascending order"
     */
    public boolean isSorted( int startAt, int endBefore) {
        for( int i = startAt
           ; i < endBefore -1 // stop early, because comparing to next
           ; i++
           )
            if( usersData.get(i).compareTo( usersData.get(i+1)) > 0) return false;
        return true;
    }
}