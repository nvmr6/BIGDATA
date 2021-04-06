from django.shortcuts import render
from .models import Post
from django.views.generic import ListView
class PostList(ListView):
    model = Post
    def get_queryset(self):
        return Post.objects.order_by('-created')
def postDetail(request, pk):
    post = Post.objects.get(pk=pk)
    context = {'post': post}
    return render(request, 'blog/post_detail.html', context=context)
class PostDetail(DetailView):
    model = Post
# def index(request):
#     # Post에 저장된 글 내용들 가져와 context 만들고 템플릿에 전달
#     posts = Post.objects.all()
#     context = {
#         'posts':posts,
#     }
#     return render(request, 'blog/post_list.html', context=context)