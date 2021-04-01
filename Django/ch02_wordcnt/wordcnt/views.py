from django.shortcuts import render


def wordinput(request):
    return render(request, "wordinput.html")

def about(request):
    return render(request, 'about.html')

