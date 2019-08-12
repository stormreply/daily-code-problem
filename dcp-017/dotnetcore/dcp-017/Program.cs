using System;
using System.Collections.Generic;
using System.Linq;

namespace dcp_017
{
  public static class Program
  {
    public static void Main(string[] args)
    {
      Console.WriteLine("Hello World!");
      Foo(2, "abcba");
    }


    public static string Foo(in int k, in string s)
    {
      var resultString = "";
      var kDistinctCharactersList = new List<char>();
      var resultList = new List<string>();

      for (var i = 0; i < s.Length; i++)
      {
        for (var j = i; j < s.Length; j++)
        {
          if (kDistinctCharactersList.Count < k && !kDistinctCharactersList.Contains(s[j]))
          {
            kDistinctCharactersList.Add(s[j]);
          }

          if (kDistinctCharactersList.Contains(s[j]))
          {
            resultString += s[j];
          } else 
          { 
            break; 
          }
        }
        resultList.Add(resultString);
        kDistinctCharactersList.Clear();
        resultString = "";
      }
      return resultList.Aggregate((max, cur) => max.Length > cur.Length ? max : cur);
    }
  }
}
