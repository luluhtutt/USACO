//Open 3
import java.io.*;
import java.util.*;

class Node {
	String name;
	int j;
	List<Node> ch;
	Node mother;
	int level;
	public Node(String name_, int j_) {
		name = name_;
		j = j_;
		ch = new ArrayList<>();
		mother = null;
		level = -1;
	}
}

public class family {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("family.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("family.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		String p = st.nextToken();
		String q = st.nextToken();
		if(p.indexOf("UNRELATED") != -1)	{
			out.println("NOT RELATED");
			out.close();
			return;
		}
		if(q.indexOf("UNRELATED") != -1)	{
			out.println("NOT RELATED");
			out.close();
			return;
		}
		if(q.equals("MOTHER"))	{
			out.println(q + " is the mother of " + p);
			out.close();
			return;
		}
		if(p.equals("MOTHER"))	{
			out.println(p + " is the mother of " + q);
			out.close();
			return;
		}
		Node pn = new Node(p, 0);
		Node qn = new Node(q, 1);
		int j = 2; // index of node
		List<Node> a = new ArrayList<>();
		a.add(pn);
		a.add(qn);
		Map<String, Integer> cn_idx = new HashMap<>(); // key: cow name  value: index of node
		cn_idx.put(p, 0);
		cn_idx.put(q, 1);
		Node proot = null;
		Node qroot = null;
		for (int k = 0; k < n; k++) {
			st = new StringTokenizer(br.readLine());
			String x = st.nextToken();
			String y = st.nextToken(); // x is mother of y
			Node xn = null;
			Node yn = null;
			if (cn_idx.containsKey(x)) {
				int xi = cn_idx.get(x);
				xn = a.get(xi);
			} else {
				xn = new Node(x, j);
				a.add(xn);
				cn_idx.put(x, j);
				j++;
			}
			
			if (cn_idx.containsKey(y)) {
				int yi = cn_idx.get(y);
				yn = a.get(yi);
			} else {
				yn = new Node(y, j);
				a.add(yn);
				cn_idx.put(y, j);
				j++;
			}
			assert(xn.name.equals(x) && yn.name.equals(y));
			assert(j == a.size() && j == cn_idx.size());
			xn.ch.add(yn);
			yn.mother = xn;
		}
		
		boolean directRelation = false;
		boolean aunt = false;
		proot = pn;
		while(proot.mother != null)	{
			proot = proot.mother;
			if(proot.equals(qn))	{
				//directRelation = true;
			}
			else if(qn.mother.equals(proot))	{
				aunt = true;
			}
		}
		qroot = pn;
		while(qroot.mother != null)	{
			qroot = qroot.mother;
			if(qroot.equals(pn))	{
				//directRelation = true;
			}
			else if(pn.mother.equals(qroot))	{
				aunt = true;
			}
		}
		if(qroot != proot)	{
			out.println("NOT RELATED");
			out.close();
			return;
		}
		
		int pl = findLevel(pn, proot, a);
		int ql = findLevel(qn, qroot, a);
		//System.out.println(pl + " " + ql);
		Node ap = pn;
		Node aq = qn;
		int apl = pl;
		int aql = ql;
		while(apl < aql) {
			aq = aq.mother;
			aql--;
		}
		while(apl > aql) {
			ap = ap.mother;
			apl--;
		}
		while(ap != aq) {
			ap = ap.mother;
			aq = aq.mother;
		}
		Node ca = ap; // lowest common ancestor
		if (ca == pn || ca == qn) {
			directRelation = true;
		}
		//System.out.println("direct relation: " + directRelation);
		int len_p = 1; // length between ca and p
		Node c = pn; // current node
		while(c.mother != ca && c.mother != null) {
			len_p++;
			c = c.mother;
		}
		int len_q = 1; // length between ca and q
		c = qn; // current node
		while(c.mother != ca && c.mother != null) {
			len_q++;
			c = c.mother;
		}
		//System.out.println("lp: " + lp + " lq: " + lq);
		if(len_q > 1 && !(len_p == 1))	{
			aunt = false;
		}
		if(len_p > 1 && !(len_q == 1))	{
			aunt = false;
		}
		if(pl == ql)	{
			aunt = false;
		}
		if(pn.mother != null && qn.mother != null && pn.mother.equals(qn.mother))	{
			out.println("SIBLINGS");
		}
		else if(directRelation)	{
			String res;
			if(pl < ql)	{
				res = pn.name + " is the ";
				if(ql-pl == 1)	{
					res += "mother of " + qn.name;
				}
				else if(ql-pl == 2)	{
					res += "grand-mother of " + qn.name;
				}
				else	{
					for(int i = 1; i < ql-pl-1; i++)	{
						res = res + "great-";
					}
					res += "grand-mother of " + qn.name;
				}
			}
			else	{
				res = qn.name + " is the ";
				if(pl-ql == 1)	{
					res += "mother of " + pn.name;
				}
				else if(pl-ql == 2)	{
					res += "grand-mother of " + pn.name;
				}
				else	{
					for(int i = 1; i < pl-ql-1; i++)	{
						res = res + "great-";
					}
					res += "grand-mother of" + pn.name;
				}
			}
			out.println(res);
		}
		else if(aunt)	{
			String res;
			if(pl < ql)	{
				res = pn.name + " is the ";
				if(ql-pl == 1)	{
					res += "aunt of " + qn.name;
				}
				else	{
					for(int i = 0; i < ql-pl-1; i++)	{
						res = res + "great-";
					}
					res += "aunt of " + qn.name;
				}
			}
			else	{
				res = qn.name + " is the ";
				if(pl-ql == 1)	{
					res += "aunt of " + pn.name;
				}
				else	{
					for(int i = 0; i < pl-ql-1; i++)	{
						res = res + "great-";
					}
					res += "aunt of " + pn.name;
				}
			}
			out.println(res);
		}
		else	{
			out.println("COUSINS");
		}
		out.close();
	}
	
	public static int findLevel(Node n, Node root, List<Node> l)	{
		if(root.equals(n))	{
			return 0;
		}
		else	{
			n = n.mother;
			return 1 + findLevel(n, root, l);
		}
	}

}
