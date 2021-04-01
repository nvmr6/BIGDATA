from django.shortcuts import render
from django.http import HttpResponse
# Create your views here.

def index(request):
    msg = "My Message"
    return render(request, 'home/index.html', {'msg': msg})

def test(request):
    return HttpResponse('<h1>test</h1>')

def intId(request, id):
    msg = '숫자 ID: ' + str(id)
    type = '숫자'
    return render(request, 'home/showId.html', {'msg':msg, 'type':type})

def strId(request, id):
    msg = '문자 ID: ' + id
    type = '문자'
    return render(request, 'home/showId.html', {'msg':msg, 'type':type})