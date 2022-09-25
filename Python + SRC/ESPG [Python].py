from random import *
from tkinter import *

def generator(x,o):
    y=''
    for i in range(o):
        y+=str(x[randint(0,len(x)-1)])
    return(y)

def dictionnary():
    dict=['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z']
    if CheckedUpperCase.get() == True:
        dict.extend(['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'])
    if CheckedNumber.get() == True:
        dict.extend(['1','2','3','4','5','6','7','8','9','0'])
    if CheckedSpecialCharacter.get() == True:
        dict.extend(['!','#','$','%','&','*','+','-','.','/',':',';','<','=','>','@','^','_','|','~'])
    return dict   

def checkifisint():
    o=int(entry1.get())
    if isinstance(o, int):
        return o

def main():
    o=dictionnary()
    u  = generator(o,int(checkifisint()))
    eText.set(u)


window_main = Tk(className="Epsilon's Simple Password Generator (Python)")
window_main.geometry("1024x568")
window_main.configure(bg='#000000')
window_main.resizable(width=False, height=False)

CheckedUpperCase=BooleanVar()
CheckedNumber=BooleanVar()
CheckedSpecialCharacter=BooleanVar()
eText=StringVar()

MainLabel = Label(window_main, width=30, height=2,
                         font=('Poppins', 25), text='Password Generator')
MainLabel.configure(bg='#000000', fg='#FFFFFF')
MainLabel.place(relx=0.799, rely=0.065, anchor='ne')

entry2 = Entry(window_main, width=30, font='Poppins')
entry2.place(relx=0.645, rely=0.29, anchor='ne')
entry2.configure(bg='#121212', fg='#808080', borderwidth=6, state="readonly", textvariable=eText,readonlybackground="#121212",)

Howmanycharacter = Label(window_main, width=30, height=2,
                         font='Poppins', text='How many character ?')
Howmanycharacter.configure(bg='#000000', fg='#FFFFFF')
Howmanycharacter.place(relx=0.63, rely=0.38, anchor='ne')

entry1= Entry(window_main, width=3,font='Poppins')
entry1.place(relx=0.38, rely=0.39, anchor='ne')
entry1.configure(bg='#121212', fg='#808080', borderwidth=6)

CheckIfModify = Checkbutton(window_main, text='Want UpperCase ? (A, B, C, ...)',
                            onvalue=1, offvalue=0, variable=CheckedUpperCase, font='Poppins', activebackground='#000000')
CheckIfModify.place(relx=0.5881, rely=0.47, anchor='ne')
CheckIfModify.configure(bg='#000000', fg='#FFFFFF', selectcolor="#121212")

CheckIfModify2 = Checkbutton(window_main, text='Want Number ? (1, 2, 3, ...)',
                             onvalue=1, offvalue=0, variable=CheckedNumber, font='Poppins', activebackground='#000000')
CheckIfModify2.place(relx=0.5531, rely=0.52, anchor='ne')
CheckIfModify2.configure(bg='#000000', fg='#FFFFFF', selectcolor="#121212")

CheckIfModify3 = Checkbutton(window_main, text='Want Special Character ? (&, +, -, #, ...)',
                             onvalue=1, offvalue=0, variable=CheckedSpecialCharacter, font='Poppins', activebackground='#000000')
CheckIfModify3.place(relx=0.66, rely=0.57, anchor='ne')
CheckIfModify3.configure(bg='#000000', fg='#FFFFFF', selectcolor="#121212")

button_submit = Button(window_main, width=28, height=1,
                       text="Submit", font='Poppins', command=main)
button_submit.place(relx=0.65, rely=0.68, anchor='ne')
button_submit.configure(bg='#121212', fg='#FFFFFF', borderwidth=6)

window_main.mainloop()
