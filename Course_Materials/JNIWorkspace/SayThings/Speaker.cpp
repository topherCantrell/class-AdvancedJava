#include <iostream>
using namespace std;

#include "Speaker.h"

JNIEXPORT void JNICALL Java_Speaker_sayHi(JNIEnv *vm, jobject me) {
	cout << "Hello there" << endl;
}

JNIEXPORT void JNICALL Java_Speaker_sayBye(JNIEnv * vm, jobject) {
	cout << "Bye now" << endl;
}
