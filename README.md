# FileRenameLibrary
2가지 방법으로 폴더 내 대상 파일들의 이름변경을 일괄 진행.

1. 파일 이름만 변경
2. 파일 이동과 함께 이름 변경.

> + 파일 이름만 변경
> ```java
> //객체생성
> FileRename fr = new FileRename("수정파일이_존재하는_폴더경로");
> 
> //대상 파일타입 세팅.
> fr.addFileType(FileTypeConst.IMAGE);
> fr.addFileType(FileTypeConst.MOVIE);
> 
> //이름변경 진행.
> fr.renameProc();
> ```

> + 파일 이동 및 이름변경
> ```java
> //객체생성 1
> FileMove fm1 = new FileMove("수정파일이_존재하는_폴더경로");
> //객체생성 2
> FileMove fm2 = new FileMove("수정파일이_존재하는_폴더경로", "이동할_대상_폴더경로");
> 
> //대상 파일타입 세팅.
> fm2.addFileType(FileTypeConst.IMAGE);
> fm2.addFileType(FileTypeConst.MOVIE);
> 
> //파일이동 진행.
> fm2.moveFileProc();
> ```

* 현재까지 구현된 내용.
  - 이미지, 영상 파일만 대상으로함.
  - 파일명은 PREFIX_yyyyMMdd_HHmmss_9999.EXTENSION 형태로 구성된다.(ex> IMG_20191214_142530_0001.jpg)
    + PREFIX : 이미지는 IMG, 영상은 MOV.
    + yyyyMMdd_HHmmss : 파일 생성일시.
    + 9999 : 시퀀스 넘버. 위 두가지 조합으로 동일한 파일이 존재할 경우 최대 시퀀스 + 1로 세팅됨.
    + EXTENSION : 확장자. 원래 확장자를 소문자로 세팅.
  - 파일 이동 시 대상폴더 아래 생성년도/생성월 폴더가 생기고 그 아래로 파일이 이동됨.

* 추후 업데이트될 내용.
  - 대상 파일포맷 추가.
  - 파일명 포맷 세팅을 옵션으로 제공.
  - 파일이동 옵션을 선택할 수 있도록 제공.
  