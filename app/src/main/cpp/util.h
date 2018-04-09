#ifndef HELLONDK_UTIL_H
#define HELLONDK_UTIL_H

#include <jni.h>
#include <string>
#include <sstream>

class Util{

public:
    Util();
    ~Util();
    std::string sayHello(const char *);
    std::string sayBye(const char *);
    std::string calculateAdd(int, int);

private:
    int add(int x, int y);

    int result;

};

#endif HELLONDK_UTIL_H
