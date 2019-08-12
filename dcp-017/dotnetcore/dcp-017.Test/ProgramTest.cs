

using Xunit;

namespace dcp_017.test
{
  public class ProgramTest
  {

    [Fact]
    public void fooTest()
    {

      string s = "abcba";
      int k = 2;
      var expected = "bcb";

      var actual = Program.Foo(k, s);

      Assert.Equal(expected, actual);
    }

    [Fact]
    public void foo2Test()
    {

      string s = "abcba";
      int k = 3;
      var expected = "abcba";

      var actual = Program.Foo(k, s);

      Assert.Equal(expected, actual);
    }
        [Fact]
    public void foo3Test()
    {

      string s = "abcbaabcbaabcbaabcba";
      int k = 2;
      var expected = "baab";

      var actual = Program.Foo(k, s);

      Assert.Equal(expected, actual);
    }
        [Fact]
    public void foo4Test()
    {

      string s = "abcbaabcbaabcbaabcba";
      int k = 3;
      var expected = "abcbaabcbaabcbaabcba";

      var actual = Program.Foo(k, s);

      Assert.Equal(expected, actual);
    }
  }
}

