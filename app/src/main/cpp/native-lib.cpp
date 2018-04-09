#include "util.h"

extern "C"
JNIEXPORT jstring
JNICALL
Java_com_pencelab_hellondk_MainActivity_getGreeting(JNIEnv *env, jobject /* this */) {
    std::string hello = "This is a c++ String";
    return env->NewStringUTF(hello.c_str());
}

extern "C"
JNIEXPORT jstring
JNICALL
Java_com_pencelab_hellondk_MainActivity_sayHello(JNIEnv *env, jobject, jstring name) {
    Util * util = new Util();
    std::string result = util->sayHello(env->GetStringUTFChars(name, 0));
    delete util;
    return env->NewStringUTF(result.c_str());
}

extern "C"
JNIEXPORT jstring
JNICALL
Java_com_pencelab_hellondk_MainActivity_sayBye(JNIEnv *env, jobject, jstring name) {
    Util * util = new Util();
    std::string result = util->sayBye(env->GetStringUTFChars(name, 0));
    delete util;
    return env->NewStringUTF(result.c_str());
}

extern "C"
JNIEXPORT jstring
JNICALL
Java_com_pencelab_hellondk_MainActivity_calculateAdd(JNIEnv *env, jobject, jint x, jint y) {
    Util * util = new Util();
    std::string result = util->calculateAdd(x, y);
    delete util;
    return env->NewStringUTF(result.c_str());
}
