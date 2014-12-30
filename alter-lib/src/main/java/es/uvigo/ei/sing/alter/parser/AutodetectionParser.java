/* Generated By:JavaCC: Do not edit this line. AutodetectionParser.java */
package es.uvigo.ei.sing.alter.parser;

import java.io.StringReader;

/**
* Autodetection parser.
* @author Daniel Gomez Blanco
* @version 1.2
*/
public class AutodetectionParser implements AutodetectionParserConstants {

  /**
  * Static method that parses an input string and returns the format of the input MSA.
  * @param in Input string.
  * @return String with the detected format.
  */
  public static String detectFormat (String in) throws ParseException
    {
        //Parse string and return MSA format
        AutodetectionParser parser = new AutodetectionParser(new StringReader(in));
        return parser.Autodetection();
    }

/**
* Grammar's root production. After omitting spaces, tabs and new lines,
* format is detected using the first words:<br>
* &nbsp;&nbsp;- If it starts with "#" or "%" it's GDE.<br>
* &nbsp;&nbsp;- If it starts with "#NEXUS" it's NEXUS.<br>
* &nbsp;&nbsp;- If it starts with "CLUSTAL", "MUSCLE" or "PROBCONS" it's ALN.<br>
* &nbsp;&nbsp;- If it starts with "PileUp", "!!AA_MULTIPLE_ALIGNMENT" or
* "!!NA_MULTIPLE_ALIGNMENT" it's MSF.<br>
* &nbsp;&nbsp;- If it starts with a number, followed by a sequence of spaces
* or tabs, and then another number, it's PHYLIP.<br>
* &nbsp;&nbsp;- If it starts with ">" followed by two characters and ";" it's PIR.<br>
* &nbsp;&nbsp;- If it starts with ">" and it doesn't meet the latter point it's FASTA.
*/
  final public String Autodetection() throws ParseException {
    String toret;
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case EOL:
      case BLANK:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case BLANK:
        jj_consume_token(BLANK);
        break;
      case EOL:
        jj_consume_token(EOL);
        break;
      default:
        jj_la1[1] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 6:
    case 7:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 6:
        jj_consume_token(6);
        break;
      case 7:
        jj_consume_token(7);
        break;
      default:
        jj_la1[2] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
            {if (true) return "gde";}
      break;
    case 8:
      jj_consume_token(8);
            {if (true) return "nexus";}
      break;
    case 9:
    case 10:
    case 11:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 9:
        jj_consume_token(9);
        break;
      case 10:
        jj_consume_token(10);
        break;
      case 11:
        jj_consume_token(11);
        break;
      default:
        jj_la1[3] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
            {if (true) return "aln";}
      break;
    case NUMBER:
      Number();
      label_2:
      while (true) {
        jj_consume_token(BLANK);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case BLANK:
          ;
          break;
        default:
          jj_la1[4] = jj_gen;
          break label_2;
        }
      }
      Number();
            {if (true) return "phylip";}
      break;
    case 12:
      jj_consume_token(12);
      if (jj_2_1(2147483647)) {
        Type();
        jj_consume_token(13);
                  {if (true) return "pir";}
      } else {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case BLANK:
        case UPPER_CASE:
        case NUMBER:
        case ANY:
        case 6:
        case 7:
        case 8:
        case 9:
        case 10:
        case 11:
        case 12:
        case 13:
        case 14:
          Line();
                  {if (true) return "fasta";}
          break;
        default:
          jj_la1[5] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
      break;
    case 14:
    case 15:
    case 16:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 14:
        jj_consume_token(14);
        break;
      case 15:
        jj_consume_token(15);
        break;
      case 16:
        jj_consume_token(16);
        break;
      default:
        jj_la1[6] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
        {if (true) return "msf";}
      break;
    default:
      jj_la1[7] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

/**
* Parses a number.
* @return Parsed number.
*/
  final public int Number() throws ParseException {
    String s = "";
    Token t;
    label_3:
    while (true) {
      t = jj_consume_token(NUMBER);
            s = s.concat(t.image);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case NUMBER:
        ;
        break;
      default:
        jj_la1[8] = jj_gen;
        break label_3;
      }
    }
        {if (true) return Integer.parseInt(s);}
    throw new Error("Missing return statement in function");
  }

/**
* Parses a PIR style type.
* @return String with the type of MSA.
*/
  final public String Type() throws ParseException {
    Token t1, t2;
    t1 = jj_consume_token(UPPER_CASE);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case UPPER_CASE:
      t2 = jj_consume_token(UPPER_CASE);
      break;
    case NUMBER:
      t2 = jj_consume_token(NUMBER);
      break;
    default:
      jj_la1[9] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
        {if (true) return t1.image + t2.image;}
    throw new Error("Missing return statement in function");
  }

/**
* Parses a line made up with any sequence of characters.
* @return Parsed line.
*/
  final public String Line() throws ParseException {
    String s = "";
    Token t;
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case BLANK:
        t = jj_consume_token(BLANK);
        break;
      case UPPER_CASE:
        t = jj_consume_token(UPPER_CASE);
        break;
      case NUMBER:
        t = jj_consume_token(NUMBER);
        break;
      case ANY:
        t = jj_consume_token(ANY);
        break;
      case 12:
        t = jj_consume_token(12);
        break;
      case 13:
        t = jj_consume_token(13);
        break;
      case 6:
        t = jj_consume_token(6);
        break;
      case 7:
        t = jj_consume_token(7);
        break;
      case 8:
        t = jj_consume_token(8);
        break;
      case 9:
        t = jj_consume_token(9);
        break;
      case 10:
        t = jj_consume_token(10);
        break;
      case 11:
        t = jj_consume_token(11);
        break;
      case 14:
        t = jj_consume_token(14);
        break;
      default:
        jj_la1[10] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
            s = s.concat(t.image);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case BLANK:
      case UPPER_CASE:
      case NUMBER:
      case ANY:
      case 6:
      case 7:
      case 8:
      case 9:
      case 10:
      case 11:
      case 12:
      case 13:
      case 14:
        ;
        break;
      default:
        jj_la1[11] = jj_gen;
        break label_4;
      }
    }
        {if (true) return s.trim();}
    throw new Error("Missing return statement in function");
  }

  private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  private boolean jj_3R_5() {
    if (jj_scan_token(UPPER_CASE)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(3)) {
    jj_scanpos = xsp;
    if (jj_scan_token(4)) return true;
    }
    return false;
  }

  private boolean jj_3_1() {
    if (jj_3R_5()) return true;
    if (jj_scan_token(13)) return true;
    return false;
  }

  /** Generated Token Manager. */
  public AutodetectionParserTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;
  private int jj_gen;
  final private int[] jj_la1 = new int[12];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x6,0x6,0xc0,0xe00,0x4,0x7ffc,0x1c000,0x1dfd0,0x10,0x18,0x7ffc,0x7ffc,};
   }
  final private JJCalls[] jj_2_rtns = new JJCalls[1];
  private boolean jj_rescan = false;
  private int jj_gc = 0;

  /** Constructor with InputStream. */
  public AutodetectionParser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public AutodetectionParser(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new AutodetectionParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public AutodetectionParser(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new AutodetectionParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public AutodetectionParser(AutodetectionParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(AutodetectionParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;
  private int[] jj_lasttokens = new int[100];
  private int jj_endpos;

  private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      jj_entries_loop: for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              continue jj_entries_loop;
            }
          }
          jj_expentries.add(jj_expentry);
          break jj_entries_loop;
        }
      }
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[17];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 12; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 17; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

  private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 1; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}