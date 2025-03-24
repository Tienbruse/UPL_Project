/* src/lexer/LexerMain.java */
package lexer;

import java.io.*;

public class LexerMain {
    public static void main(String[] args) throws IOException {
        Reader reader = new InputStreamReader(System.in);
        Lexer lexer = new Lexer(reader);
        int token;
        while ((token = lexer.yylex()) != Lexer.YYEOF) {
            String tokenName;
            switch (token) {
                case Lexer.BEGIN: tokenName = "BEGIN"; break;
                case Lexer.END: tokenName = "END"; break;
                case Lexer.INT: tokenName = "INT"; break;
                case Lexer.BOOL: tokenName = "BOOL"; break;
                case Lexer.IF: tokenName = "IF"; break;
                case Lexer.THEN: tokenName = "THEN"; break;
                case Lexer.ELSE: tokenName = "ELSE"; break;
                case Lexer.DO: tokenName = "DO"; break;
                case Lexer.WHILE: tokenName = "WHILE"; break;
                case Lexer.FOR: tokenName = "FOR"; break;
                case Lexer.PRINT: tokenName = "PRINT"; break;
                case Lexer.TRUE: tokenName = "TRUE"; break;
                case Lexer.FALSE: tokenName = "FALSE"; break;
                case Lexer.ID: tokenName = "ID"; break;
                case Lexer.NUMBER: tokenName = "NUMBER"; break;
                case Lexer.GT: tokenName = "GT"; break;
                case Lexer.GE: tokenName = "GE"; break;
                case Lexer.EQ: tokenName = "EQ"; break;
                case Lexer.PLUS: tokenName = "PLUS"; break;
                case Lexer.MULT: tokenName = "MULT"; break;
                case Lexer.ASSIGN: tokenName = "ASSIGN"; break;
                case Lexer.SEMICOLON: tokenName = "SEMICOLON"; break;
                case Lexer.LPAREN: tokenName = "LPAREN"; break;
                case Lexer.RPAREN: tokenName = "RPAREN"; break;
                case Lexer.LBRACE: tokenName = "LBRACE"; break;
                case Lexer.RBRACE: tokenName = "RBRACE"; break;
                case Lexer.ERROR: tokenName = "ERROR"; break;
                default: tokenName = "UNKNOWN"; break;
            }
            System.out.println("Token: " + tokenName + ", Value: " + lexer.getTokenValue());
        }
    }
}