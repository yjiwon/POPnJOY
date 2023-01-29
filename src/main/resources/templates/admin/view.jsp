<!DOCTYPE html>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<html xmlns:th="http://www.thymeleaf.org" lang="en" xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
      layout:decoration = "pos/layout/pos_layout">

    <head>
        <meta charset="UTF-8">

<style>
	body { font-family:'맑은 고딕', verdana; padding:0; margin:0; }
	ul { padding:0; margin:0; list-style:none;  }

	div#root { width:90%; margin:0 auto; }

	content#content { font-size:60px; padding:20px 0; }
	content#content h1 a { color:#000; font-weight:bold; }

	nav#nav { padding:10px; text-align:right; }
	nav#nav ul li { display:inline-block; margin-left:10px; }

     section#container { padding:20px 0; border-top:2px solid #eee; border-bottom:2px solid #eee; }
	section#container::after { content:""; display:block; clear:both; }
	aside { float:left; width:200px; }
	div#container_box { float:right; width:calc(100% - 200px - 20px); }

	aside ul li { text-align:center; margin-bottom:10px; }
	aside ul li a { display:block; width:100%; padding:10px 0;}
	aside ul li a:hover { background:#eee; }
</style>

<style>
    .inputArea { margin:10px 0; }
    select { width:100px; }
    label { display:inline-block; width:70px; padding:5px; }
    label[for='gdsDes'] { display:block; }
    input { width:150px; }
    textarea#gdsDes { width:400px; height:180px; }
</style>


    </head>

    <body>
    <th:block layout:fragment="content">

   <nav id="nav" >
<div th:replace="~{/fragments/main}" ></div>
   </nav>


        <section id="container">
        <aside>
            <div th:replace="~{/fragments/aside}" ></div>
        </aside>
        </section>

        <div id="container_box">

            <form th:role="form" th:method="post" th:autocomplete="off">

                <input type="hidden" name="gdsId" th:value="${goods.gdsId}">
                <input type="hidden" name="userId" th:value="${goods.userId}">


                    <div class="inputArea">
                        <label for="gdsCat">카테고리</label>
                        <input type="text" id="gdsCat" name="gdsCat" th:value="${goods.gdsCat}" />
                    </div>

                <div class="inputArea">
                    <label for="gdsName">상품명</label>
                    <input type="text" id="gdsName" name="gdsName" th:value="${goods.gdsName}" />
                </div>


                <div class="inputArea">
                    <label for="gdsPrice">상품가격</label>
                    <input type="text" id="gdsPrice" name="gdsPrice" th:value="${goods.gdsPrice}" />
                </div>

                <div class="inputArea">
                    <label for="gdsStock">상품수량</label>
                    <input type="text" id="gdsStock" name="gdsStock" th:value="${goods.gdsStock}"/>
                </div>

                <div class="inputArea">
                    <label for="gdsDes">상품소개</label>
                    <textarea rows="5" cols="50" id="gdsDes" name="gdsDes" th:value="${goods.gdsDes}" ></textarea>
                    <div th:if="${goods.gdsImg != null}">
                    <img alt="" src="/admin/displayFile?fileName=${goods.gdsImg}">
                    </div>
                </div>



                    <div class="inputArea">
                    <button type="button" id="modify_Btn" class="btn btn-warning">수정</button>
                    <button type="button" id="delete_Btn" class="btn btn-danger">삭제</button>

                    <script th:inline="javascript" >
					var formObj = $("form[role='form']");

					$("#modify_Btn").click(function(){
						formObj.attr("action", "/admin/modify");
						formObj.attr("method", "get")
						formObj.submit();
					});

					$("#delete_Btn").click(function(){

						var con = confirm("정말로 삭제하시겠습니까?");

						if(con) {
							formObj.attr("action", "/admin/delete");
							formObj.submit();
						}
					});
				</script>


                </div>

            </form>


            </div>


    </th:block>
    </body>
</html>