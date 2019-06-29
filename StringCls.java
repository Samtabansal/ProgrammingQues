/*  
    Functions present in the class :-  

    equal(String, String)
    String sortArray(String)
    String longest(String)
    void palindrome(String)
    void anagram(String, String)
    void rotate(String, int)
    String reverse(String)
    String reverseWord(String)
    String reverseLine(String)
    int countChar(String, char)
    char repeatedChar(String)
    String duplicateChar(String, char)
    String removeChar(String, char)
*/ 

class StringCls 
{
    public static void main(String []z)
    {
        String st = "bananas";
        System.out.println(longest(st));
    }
    
    
    static String longest(String st)
    {
        String []temp = new String[50];
        int l=0;
        String t="";
        char []ar = st.toCharArray();
        for(int i=0;i<st.length();i++)
        {
            String s=""+ar[i];
            for(int j=i+1;j<st.length();j++)
            {   
                s += ar[j];
                if(palindrome(s) ==1)
                {                   
                    temp[l]=s;
                    l++;
                }
            }
        }
        int index=0,max=0;
        while(temp[index]!= null)
        {
            if(temp[index].length() >= max)
            {
                max = temp[index].length();
                t = temp[index];
            }
            index++;
        }
        
        return t;
    }
    
    static void rotate(String st, int rot)
    {
        char []ar = st.toCharArray();
        String str="";
        String temp="";
        for(int i=0;i<rot;i++)
           str += ar[i];
        
        for(int j=rot;j<st.length();j++)
            temp += ar[j]; 
        
        str  = reverse(str);
        temp = temp+str;
        if(equal(temp, st) == 1)
            System.out.println("true");
        else
            System.out.println("False");
    }
    
    static char repeatedChar(String st)
    {
        char ch='#';
        char []ar = st.toCharArray();
        for(int i=0;i<st.length();i++)
        {
            int flag=0;
            for(int j=0;j<st.length();j++)
            { 
                if(ar[i] == ar[j])
                   flag++;
            }
            if(flag == 1)
            {
                ch = ar[i];
                break;
            }  
        }
        return ch;
    }
    
    static void anagram(String at , String bt)
    {
       String a = sortArray(at);
       String b = sortArray(bt);
       if(equal(a,b) == 1)
            System.out.println("Anagram");
        else
            System.out.println(" Not Anagram ");
    }  
    
    static String sortArray(String st)
    {
       char []ar = st.toCharArray();
       char temp;
       
       for(int i=0;i<st.length();i++)
       {
            for(int j=0;j<st.length()-i-1;j++)
            {   
                if(ar[j] > ar[j+1])
                {
                    temp = ar[j];
                    ar[j] = ar[j+1];
                    ar[j+1] = temp;
                }   
            }
        }
       return new String(ar);
    }
    
    static String duplicateChar(String st, char ch)
    {
       char []ar = st.toCharArray();
       String temp="";
       for(int i=0;i<st.length();i++)
        {
            if(ar[i] != ch)
                temp += ar[i];
        }
       return temp;
    }
    
    static String reverseLine(String st)
    {
       char []ar = st.toCharArray();
       String temp="";
       String str="";
       for(int i=0;i<st.length();i++)
        {
            if(ar[i] != ' ')
                str = ar[i] + str;
            else
            {
                temp = temp + ' ' + str;
                str="";
            }
        }
       String k = temp + ' ' + str;
       return(reverse(k));
    }
    
    static String reverseWord(String st)
    {
       char []ar = st.toCharArray();
       String temp="";
       String str="";
       for(int i=0;i<st.length();i++)
        {
            if(ar[i] != ' ')
                str = ar[i] + str;
            else
            {
                temp = temp + ' ' + str;
                str="";
            }
        }
       return(temp + ' ' + str);
    }
    
    static int countChar(String st, char ch)
    {
       char []ar = st.toCharArray();
       int temp=0;
       for(int i=0;i<st.length();i++)
        {
            if(ar[i] == ch)
                temp += 1;
        }
       return temp;
    }
    
    static String removeChar(String st, char ch)
    {
       char []ar = st.toCharArray();
       String temp="";
       for(int i=0;i<st.length();i++)
        {
            if(ar[i] != ch)
                temp += ar[i];
        }
       return temp;
    }
    
    static String reverse(String st)
    {
        char []ar = st.toCharArray();
        char [] temp = new char[st.length()];
        int j=0;
        for(int i=st.length()-1;i>=0;i--)
        {
            temp[j]=ar[i];
            j++;
        }
        
        return new String(temp);
    }
    
    static int palindrome(String st)
    {
        int flag=0;       
        String t = reverse(st);
        char []ar = st.toCharArray();
        char []temp = t.toCharArray();
        int len = st.length();
        for(int i=0;i<len;i++)
        {
            if(temp[i]==ar[i])
                flag++;
        }
        if(flag == len)
        {
//            System.out.println("Palindrome");
            return 1;
        }           
        else
        {
//            System.out.println("Not Palindrome");
            return 0;
        }
    }
    
    static int equal(String one, String two)
    {
        int flag=0;
        char []a = one.toCharArray();
        char []b = two.toCharArray();
        
        int len = one.length();
        int lenB = two.length();
        
        if(lenB != len)
            return 0;
        else{
            for(int i=0;i<len;i++)
            {
                if(a[i]==b[i])
                    flag++;
            }
        }
        
        if(flag == len)
            return 1;
        else
            return 0;
    }
}


