package com.mosaiker.ccalculator.service;

import java.text.DecimalFormat;

public class calculator {
    public calculator() {

    }
    public float readE(tokenStream tks) throws MyException{
        float result = readT(tks);
        while (true) {
            Token t = tks.get();
            if (t.type == 0) {
                //结束了
                return result;
            }
            if (t.type != 2 && t.type != 3) {
                throw new MyException("expression error1.");
            } else {
                switch (t.value) {
                    case '+':
                        result += readT(tks);
                        break;
                    case '-':
                        result -= readT(tks);
                        break;
                    default:
                        tks.unget(t);
                        return result;
                }
            }
        }

    }

    public float readT(tokenStream tks) throws MyException{
        float result = readP(tks);
        while (true) {
            Token t = tks.get();
            if (t.type == 0) {
                //结束了
                return result;
            }
            if (t.type != 2 && t.type != 3) {
                throw new MyException("expression error2.");
            } else {
                switch (t.value) {
                    case '*':
                        result *= readP(tks);
                        break;
                    case '/':
                        result /= readP(tks);
                        break;
                    case '%':
                        result %= readP(tks);
                        break;
                    default:
                        tks.unget(t);
                        return result;
                }
            }
        }
    }

    public float readP(tokenStream tks) throws MyException{
        Token t = tks.get();
        float result = 0f;
        switch (t.type) {
            case 2:
                if (t.value != '-') {
                    throw new MyException("unexpected token.");
                }
            case 1:
                StringBuilder num = new StringBuilder(String.valueOf(t.value));
                t = tks.get();
                while (t.type == 1) {
                    num.append(t.value);
                    t = tks.get();
                }
                tks.unget(t);
                result = Float.parseFloat(num.toString());
                break;
            case 3:
                if (t.value == '(') {
                    result = readE(tks);
                    Token tk = tks.get();
                    if (tk.value == ')') {
                        break;
                    } else {
                        throw new MyException("unexpected token");
                    }
                } else {
                    throw new MyException("unexpected token");
                }
            case 0:
                //没有东西了，错误
                throw new MyException("invalid expression");
            default:
                throw new MyException("invalid token");
        }
        return result;
    }

    public String cal(String formula) {
        tokenStream tks = new tokenStream(formula);
        try {
            float result = readE(tks);
            DecimalFormat df = new DecimalFormat("0.0000");
            String formatResult = df.format(result);
            return formatResult;
        } catch (MyException e) {
            return e.getMsg();
            //System.out.println(e.getMsg());
            //e.printStackTrace();
        } catch (Exception e) {
            return e.getMessage();
            //System.out.println(e.getMessage());
            //e.printStackTrace();
        }
    }
}
