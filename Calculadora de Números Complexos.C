/* Nome: Filipe Miorin de Lima 
   Projeto 1: Calculadora de Numeros Complexos
*/

#include<stdio.h>
#include<stdlib.h>
#include<locale.h>
#include<string.h>

int imprime_menu(int a) {
    int b=0;
    //função apenas para imprimir o menu;
    puts("*********************************************");
    puts("*      CALCULADORA DE NÚMEROS COMPLEXOS     *");
    puts("*                                           *");
    puts("* 1)-Inserir um número complexo em um vetor *");
    puts("* 2)-Imprimir um vetor de número complexo   *");
    puts("* 3)-Soma de números complexos              *");
    puts("* 4)-Subtração de números complexos         *");
    puts("* 5)-Multiplicação de números complexos     *");
    puts("* 6)-Divisão de números complexos           *");
    puts("* 7)-Sair do programa                       *");
    puts("*                                           *");
    puts("*********************************************");

    scanf("%d",&b);
    a=b;
    return a;
}

void soma(float real[],float imag[]){
    float resr,resi;
    int n=0,ni=0;
    resr = (real[n]+real[n+1]);
    resi = (imag[ni]+imag[ni+1]);
    if(resi<0){
        printf("%.2f %.2fi\n",resr,resi);
    }else printf("%.2f + %.2fi\n",resr,resi);
}

void subtr(float real[],float imag[]){
    float resr,resi;
    int n=0,ni=0;
    resr = (real[n]-real[n+1]);
    resi = (imag[ni]-imag[ni+1]);
    if(resi<0){
        printf("%.2f %.2fi\n",resr,resi);
    }else printf("%.2f + %.2fi\n",resr,resi);
}

void mult(float real[],float imag[]){
    float res,res1;
    res=((real[0]*real[1])-(imag[0]*imag[1]));
    res1=((real[0]*imag[1])+(real[1]*imag[0]));
    
    printf("%.1f %.1fi\n",res,res1);
}

void divi(float real[],float imag[]){
    float deno,res1,res;
    res=((real[0]*real[1])-(imag[0]*imag[1]));
    res1=((real[0]*imag[1])+(real[1]*imag[0]));
    deno= ((real[1]*real[1])+(imag[1]*imag[1]));

    printf("%.1f/%.1f %.1fi/%.1f\n",res,deno,res1,deno);
}

int main(){
    int a=0,p=0,rep=1,k,k1;
    int i,j=0;
    char vec[50][50];
    float real[10],imag[10],r,r1;
    char *aux,*aux1;
    do{
        a=imprime_menu(a);

        switch (a){
            case 1:
            // colocar os numeros complexos na matriz
            puts("insira quantos numeros complexos ira adicionar ao vetor");
            scanf("%d",&p);
            for(i=0;i<p;i++){
                setbuf(stdin,NULL);
                printf("Insira os numeros complexos:\n");
                scanf("%[^\n]s",vec[i]);
            }
            //chamar funçao menu pegar outra ação ou encerrar
            puts("deseja sair do programa?  se sim digite 0");
            scanf("%d",&rep);
        break;
        case 2:
            //função de impressão de complexos
            for(i=0;i<p;i++){
                printf("%d- %s\n",i,vec[i]);
            }
            //chamar funçao menu pegar outra ação
            puts("deseja sair do programa?  se sim digite 0");
            scanf("%d",&rep);
        break;
        case 3:
            // chamar func de soma
            printf("Digite aposição dos numeros no vetor");
            scanf("%d %d",&k,&k1);
            r=strtof(vec[k],&aux);
            real[0]=r;
            r=strtof(aux,NULL);
            imag[0]=r;
            r1=strtof(vec[k1],&aux1);
            real[1]=r1;
            r1=strtof(aux1,NULL);
            imag[1]=r1;
            soma(real,imag);
            //chamar funçao menu pegar outra ação
            puts("deseja sair do programa?  se sim digite 0");
            scanf("%d",&rep);
        break;
        case 4:
            // call func sub
            printf("Digite aposição dos numeros no vetor");
            scanf("%d %d",&k,&k1);
            r=strtof(vec[k],&aux);
            real[0]=r;
            r=strtof(aux,NULL);
            imag[0]=r;
            r1=strtof(vec[k1],&aux1);
            real[1]=r1;
            r1=strtof(aux1,NULL);
            imag[1]=r1;
            subtr(real,imag);
            //chamar funçao menu pegar outra ação
            puts("deseja sair do programa?  se sim digite 0");
            scanf("%d",&rep);
        break;
        case 5:
            // call func mult
            printf("Digite aposição dos numeros no vetor");
            scanf("%d %d",&k,&k1);
            r=strtof(vec[k],&aux);
            real[0]=r;
            r=strtof(aux,NULL);
            imag[0]=r;
            r1=strtof(vec[k1],&aux1);
            real[1]=r1;
            r1=strtof(aux1,NULL);
            imag[1]=r1;
            mult(real,imag);
            //chamar funçao menu pegar outra ação
            puts("deseja sair do programa?  se sim digite 0");
            scanf("%d",&rep);
        break;
        case 6:
            //call func divi
            printf("Digite aposição dos numeros no vetor");
            scanf("%d %d",&k,&k1);
            r=strtof(vec[k],&aux);
            real[0]=r;
            r=strtof(aux,NULL);
            imag[0]=r;
            r1=strtof(vec[k1],&aux1);
            real[1]=r1;
            r1=strtof(aux1,NULL);
            imag[1]=r1;
            divi(real,imag);
            //chamar funçao menu pegar outra ação
            puts("deseja sair do programa?  se sim digite 0");
            scanf("%d",&rep);
        break;
        case 7:
            // sair do programa
            puts("deseja realmente sair do programa se sim digite 0 de nao digite 1");
            scanf("%d",&rep);
        break;
    }
    }while(rep!=0);

    return 0;
}
