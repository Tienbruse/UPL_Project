package lexer;

import java.io.*;

public class LexerManual {
    private String input;
    private int pos;

    public LexerManual(String input) {
        this.input = input;
        this.pos = 0;
    }

    public String nextToken() {
        skipWhitespaceAndComments();
        if (pos >= input.length()) return "EOF";

        char c = input.charAt(pos);
        if (Character.isLetter(c)) return readIdentifierOrKeyword();
        if (Character.isDigit(c)) return readNumber();
        if (c == '>') return readComparison();
        if (c == '=') return readEqualsOrAssign();
        if (c == '+') { pos++; return "PLUS:+"; }
        if (c == '*') { pos++; return "MULT:*"; }
        if (c == ';') { pos++; return "SEMICOLON:;"; }
        if (c == '(') { pos++; return "LPAREN:("; }
        if (c == ')') { pos++; return "RPAREN:)"; }
        if (c == '{') { pos++; return "LBRACE:{"; }
        if (c == '}') { pos++; return "RBRACE:}"; }

        pos++;
        return "ERROR:Invalid char " + c;
    }

    private void skipWhitespaceAndComments() {
        while (pos < input.length() && Character.isWhitespace(input.charAt(pos))) pos++;
        if (pos + 1 < input.length() && input.startsWith("/*", pos)) {
            pos += 2;
            while (pos + 1 < input.length() && !input.startsWith("*/", pos)) pos++;
            pos += 2;
            skipWhitespaceAndComments();
        }
        if (pos + 1 < input.length() && input.startsWith("//", pos)) {
            while (pos < input.length() && input.charAt(pos) != '\n') pos++;
            skipWhitespaceAndComments();
        }
    }

    private String readIdentifierOrKeyword() {
        int start = pos;
        while (pos < input.length() && (Character.isLetterOrDigit(input.charAt(pos)))) pos++;
        String value = input.substring(start, pos);
        switch (value) {
            case "begin": return "BEGIN:" + value;
            case "end": return "END:" + value;
            case "int": return "INT:" + value;
            case "bool": return "BOOL:" + value;
            case "if": return "IF:" + value;
            case "then": return "THEN:" + value;
            case "else": return "ELSE:" + value;
            case "do": return "DO:" + value;
            case "while": return "WHILE:" + value;
            case "for": return "FOR:" + value;
            case "print": return "PRINT:" + value;
            case "true": return "TRUE:" + value;
            case "false": return "FALSE:" + value;
            default: return "ID:" + value;
        }
    }

    private String readNumber() {
        int start = pos;
        while (pos < input.length() && Character.isDigit(input.charAt(pos))) pos++;
        return "NUMBER:" + input.substring(start, pos);
    }

    private String readComparison() {
        pos++;
        if (pos < input.length() && input.charAt(pos) == '=') {
            pos++;
            return "GE:>=";
        }
        return "GT:>";
    }

    private String readEqualsOrAssign() {
        pos++;
        if (pos < input.length() && input.charAt(pos) == '=') {
            pos++;
            return "EQ:==";
        }
        return "ASSIGN:=";
    }

    public static void main(String[] args) throws IOException {
        String input = "begin int x; int y=x+1; /* comments */ bool a; print(a+1); end";
        LexerManual lexer = new LexerManual(input);
        String token;
        while (!(token = lexer.nextToken()).equals("EOF")) {
            System.out.println(token);
        }
    }
}