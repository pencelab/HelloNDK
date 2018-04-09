#include "util.h"

Util::Util() {
    this->result = 0;
}

Util::~Util() {
    this->result = 0;
}

std::string Util::sayHello(const char * name) {
    std::string hello = "Hello ";
    hello.append(name);
    hello.append("!!!");
    return hello;
}

std::string Util::sayBye(const char * name) {
    std::string hello = "Bye ";
    hello.append(name);
    hello.append("!!!");
    return hello;
}

std::string Util::calculateAdd(int x, int y) {
    this->result = this->add(x, y);

    std::ostringstream sum ;
    sum << this->result;
    std::string calc  = "Result: ";
    calc.append(sum.str());
    return calc;
}

int Util::add(int x, int y) {
    return x + y;
}