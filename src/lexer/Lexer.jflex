/* src/lexer/Lexer.jflex */
package lexer;
%%

%public
%class Lexer
%unicode
%type int

%line
%column

%{
    // Định nghĩa mã token
    public static final int BEGIN = 1;
    public static final int END = 2;
    public static final int INT = 3;
    public static final int BOOL = 4;
    public static final int IF = 5;
    public static final int THEN = 6;
    public static final int ELSE = 7;
    public static final int DO = 8;
    public static final int WHILE = 9;
    public static final int FOR = 10;
    public static final int PRINT = 11;
    public static final int TRUE = 12;
    public static final int FALSE = 13;
    public static final int ID = 14;
    public static final int NUMBER = 15;
    public static final int GT = 16;
    public static final int GE = 17;
    public static final int EQ = 18;
    public static final int PLUS = 19;
    public static final int MULT = 20;
    public static final int ASSIGN = 21;
    public static final int SEMICOLON = 22;
    public static final int LPAREN = 23;
    public static final int RPAREN = 24;
    public static final int LBRACE = 25;
    public static final int RBRACE = 26;
    public static final int ERROR = 27;

    // Lưu giá trị của token
    private String tokenValue;
    public String getTokenValue() {
        return tokenValue;
    }
%}

Letter = [a-zA-Z]
Digit = [0-9]
Identifier = {Letter}+ ({Digit})*
Number = {Digit}+
WhiteSpace = [ \t\n\r]+
CommentLine = "//" [^\n]*
CommentBlock = "/*" ~"*/"

%%

"begin"         { tokenValue = yytext(); return BEGIN; }
"end"           { tokenValue = yytext(); return END; }
"int"           { tokenValue = yytext(); return INT; }
"bool"          { tokenValue = yytext(); return BOOL; }
"if"            { tokenValue = yytext(); return IF; }
"then"          { tokenValue = yytext(); return THEN; }
"else"          { tokenValue = yytext(); return ELSE; }
"do"            { tokenValue = yytext(); return DO; }
"while"         { tokenValue = yytext(); return WHILE; }
"for"           { tokenValue = yytext(); return FOR; }
"print"         { tokenValue = yytext(); return PRINT; }
"true"          { tokenValue = yytext(); return TRUE; }
"false"         { tokenValue = yytext(); return FALSE; }

{Identifier}    { tokenValue = yytext(); return ID; }
{Number}        { tokenValue = yytext(); return NUMBER; }

">"             { tokenValue = yytext(); return GT; }
">="            { tokenValue = yytext(); return GE; }
"=="            { tokenValue = yytext(); return EQ; }
"+"             { tokenValue = yytext(); return PLUS; }
"*"             { tokenValue = yytext(); return MULT; }
"="             { tokenValue = yytext(); return ASSIGN; }
";"             { tokenValue = yytext(); return SEMICOLON; }
"("             { tokenValue = yytext(); return LPAREN; }
")"             { tokenValue = yytext(); return RPAREN; }
"{"             { tokenValue = yytext(); return LBRACE; }
"}"             { tokenValue = yytext(); return RBRACE; }

{WhiteSpace}    { /* Ignore whitespace */ }
{CommentLine}   { /* Ignore line comments */ }
{CommentBlock}  { /* Ignore block comments */ }

<<EOF>>         { return YYEOF; }
.               { tokenValue = yytext(); return ERROR; }