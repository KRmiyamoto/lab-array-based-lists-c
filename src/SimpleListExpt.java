import java.io.PrintWriter;
import java.util.ListIterator;

/**
 * Some simple experiments with SimpleLists
 * @author Samuel Rebelsky
 */
public class SimpleListExpt {

  /**
   * Add an element using an iterator.
   */
  static void add(PrintWriter pen, ListIterator<String> it, String val)
      throws Exception {
    pen.println("Add \"" + val + "\" at position " + it.nextIndex());
    it.add(val);
  } // add(PrintWriter)

  /**
   * Print a list.
   */
  static void printList(PrintWriter pen, SimpleList<String> lst) {
    int i = 0;
    for (String val : lst) {
      pen.println(i++ + ": " + val);
    } // for
  } // printList(PrintWriter, SimpleList<String>)

  /**
   * Add a variety of elements.
   */
  static void expt(PrintWriter pen, SimpleList<String> lst, String[] vals)
      throws Exception {
    pen.println("Current list: ");
    printList(pen, lst);
    pen.println();

    ListIterator<String> lit = lst.listIterator();

    for (int i = 0; i < vals.length; i++) {
      add(pen, lit, vals[i]);
      printList(pen, lst);
      pen.println();
    } // for
  } // expt(PrintWriter, SimpleList<String>, String[])

  /**
   * Check 'set' by setting elements 0, 2, and 4 of a 6-element list.
   */
  static void setExpt(PrintWriter pen, SimpleList<String> lst, String str) throws Exception {
    pen.println("Current list: ");
    printList(pen, lst);
    pen.println();

    ListIterator<String> lit = lst.listIterator();

    while (lit.hasNext()) {
      lit.next();
      lit.set(str);
      printList(pen, lst);
      pen.println();
      if (lit.hasNext()) {
        lit.next();
      } // if
    } // while
  } // set(PrintWriter SimpleList<String>, String[])

   /**
   * Check 'set' works with 'previous' by setting elements 0, 2, and 4 of a 6-element list,
   * walking backwards from list end.
   */
  static void setExpt2(PrintWriter pen, SimpleList<String> lst, String str) throws Exception {
    pen.println("Current list: ");
    printList(pen, lst);
    pen.println();

    ListIterator<String> lit = lst.listIterator();
    while (lit.hasNext()) {
      lit.next();
    } // while

    while (lit.hasPrevious()) {
      lit.previous();
      lit.set(str);
      printList(pen, lst);
      pen.println();
      if (lit.hasPrevious()) {
        lit.previous();
      } // if
    } // while
  } // set(PrintWriter SimpleList<String>, String[])

  /**
   * Test remove.
   */
  static void removeExpt(PrintWriter pen, SimpleList<String> lst) throws Exception {
    pen.println("Current list: ");
    printList(pen, lst);
    pen.println();

    ListIterator<String> lit = lst.listIterator();

    while (lit.hasNext()) {
      lit.next();
      lit.remove();
      printList(pen, lst);
      pen.println();
    } // while
  } // set(PrintWriter SimpleList<String>, String[])

  /** 
  * Test remove, walking backward.
  */
 static void removeExpt2(PrintWriter pen, SimpleList<String> lst) throws Exception {
   pen.println("Current list: ");
   printList(pen, lst);
   pen.println();

   ListIterator<String> lit = lst.listIterator();
   while (lit.hasNext()) {
     lit.next();
   } // while

   while (lit.hasPrevious()) {
     lit.previous();
     lit.remove();
     printList(pen, lst);
     pen.println();
   } // while
 } // set(PrintWriter SimpleList<String>, String[])

  /**
   * My default experiment.
   */
  static void expt(PrintWriter pen, SimpleList<String> lst) throws Exception {
    expt(pen, lst, new String[] {"alpha", "bravo", "charlie"});
    expt(pen, lst, new String[] {"aardvark", "anteater", "antelope"});
    setExpt(pen, lst, "next");
    setExpt2(pen, lst, "prev");
    removeExpt(pen, lst);
    removeExpt2(pen, lst);
  } // expt(PrintWriter, SimpleList<String>)


} // class SimpleListExpt
