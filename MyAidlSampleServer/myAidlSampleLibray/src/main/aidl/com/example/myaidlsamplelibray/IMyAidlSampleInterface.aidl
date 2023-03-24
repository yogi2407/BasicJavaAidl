// IMyAidlSampleInterface.aidl
package com.example.myaidlsamplelibray;

// Declare any non-default types here with import statements

interface IMyAidlSampleInterface {

   int onAddCommand(int firstnum,int Secondnum);
   int onSubCommand(int firstnum,int Secondnum);
   int onMultiplyCommand(int firstnum,int Secondnum);
   int onDivideCommand(int firstnum,int Secondnum);
   int calculationMethod(int firstnum,int Secondnum,int OperationType);

}