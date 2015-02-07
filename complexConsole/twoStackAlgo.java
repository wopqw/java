import java.util.TreeMap;
public class twoStackAlgo
{
  public double evaluation(String text)
  {
    text = "("+text+")";
    TreeMap<String,Integer> precedence = new TreeMap<String,Integer>();
    precedence.put(")",0);
    precedence.put("(",0);
    precedence.put("+",1);
    precedence.put("-",1);
    precedence.put("*",2);
    precedence.put("/",2);
    Stack<String> ops = new Stack<String>();
    Stack<Double> vals = new Stack<Double>();
    int len = text.length();
    for (int i=0;i<len;i++)
    {
      String sign = String.valueOf(text.charAt(i));
      if (!precedence.containsKey(sign))
      {
        vals.push(Double.parseDouble(sign));
        continue;
      }
      while (true)
      {
        if (ops.isEmpty()||sign.equals("(")||(precedence.get(sign)>precedence.get(ops.peek())))
        {
          ops.push(sign);
          break;
        }
        String op = ops.pop();
        if (op.equals("("))
        {
          assert sign.equals(")");
          break;
        }
        else
        {
          double val2 = vals.pop();
          double val1 = vals.pop();
          vals.push(eval(op,val1,val2));
        }
      }
    }
    while (!ops.isEmpty())
    {
      String op = ops.pop();
      double val2 = vals.pop();
      double val1 = vals.pop();
      vals.push(eval(op, val1, val2));
    }
    double answ = vals.pop();
    return answ;
  }
  public static double eval(String op, double val1, double val2) {
        if (op.equals("+")) return val1 + val2;
        if (op.equals("-")) return val1 - val2;
        if (op.equals("/")) return val1 / val2;
        if (op.equals("*")) return val1 * val2;
        throw new RuntimeException("Invalid operator");
    }
  /*public double Dijkstra(String text)
  {
    Stack<String> ops = new Stack<String>();
    Stack<Double> vals = new Stack<Double>();
    text = "("+text+")";
    int len = text.length();
    for (int i=0;i<len;i++)
    {
      String sign = String.valueOf(text.charAt(i));
      if (sign.equals("("))
      {

      }
      else if (sign.equals("+"))
      {
        ops.push(sign);
      }
      else if (sign.equals("-"))
      {
        ops.push(sign);
      }
      else if (sign.equals("*"))
      {
        ops.push(sign);
      }
      else if (sign.equals("/"))
      {
        ops.push(sign);
      }
      else if (sign.equals(")"))
      {
        String op = ops.pop();
        double v = vals.pop();
        if (op.equals("+"))
        {
          v = vals.pop()+v;
        }
        else if (op.equals("-"))
        {
          v = vals.pop()-v;
        }
        else if (op.equals("/"))
        {
          v = vals.pop()/v;
        }
        else if (op.equals("*"))
        {
          v = vals.pop()*v;
        }
        vals.push(v);
      }
      else
      {
        vals.push(Double.parseDouble(sign));
      }
      //ops.print();
      //vals.print();
    }
    if (vals.size()!=1)
    {
      while (vals.size()!=1)
      {
        String op = ops.pop();
        double v = vals.pop();
        if (op.equals("+"))
        {
          v = vals.pop()+v;
        }
        else if (op.equals("-"))
        {
          v = vals.pop()-v;
        }
        else if (op.equals("/"))
        {
          v = vals.pop()/v;
        }
        else if (op.equals("*"))
        {
          v = vals.pop()*v;
        }
        vals.push(v);
      }
    }
    double answ = vals.pop();
    return answ;
  }*/
}
