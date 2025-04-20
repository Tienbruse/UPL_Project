# UPL Lexer Project

## Cấu trúc thư mục
- `src/lexer/`: Chứa mã nguồn Java thủ công (`LexerManual.java`).
- `input/`: Chứa file input mẫu (`test_input.upl`).
- `output/`: Chứa kết quả output (`output.txt`).
- `src/grammar`: Chứa văn phạm (`UPLGrammar.txt`).

### Jflex
1. jflex src/lexer/Lexer.jflex
2. javac src/lexer/Lexer.java src/lexer/LexerMain.java
3. java -cp src lexer.LexerMain < input/test_input.upl > output/jflex_output.txt

### Java thủ công
1. Biên dịch: `javac -d bin src/lexer/LexerManual.java`
2. Chạy: `java -cp bin lexer.LexerManual < input/test_input.upl > output/output.txt`
