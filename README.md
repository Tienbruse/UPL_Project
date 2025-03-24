# UPL Lexer Project

## Cấu trúc thư mục
- `src/lexer/`: Chứa mã nguồn Java thủ công (`LexerManual.java`).
- `input/`: Chứa file input mẫu (`test_input.upl`).
- `output/`: Chứa kết quả output (`output.txt`).
- `src/grammar`: Chứa văn phạm (`UPLGrammar.txt`).

### Java thủ công
1. Biên dịch: `javac -d bin src/lexer/LexerManual.java`
2. Chạy: `java -cp bin lexer.LexerManual < input/test_input.upl > output/output.txt`
