# 익수자의 동작 패턴을 기반으로 한 구조시스템
2022-2 융합캡스톤디자인 - 산통산통

---

Project Inproduction
===

> 전문적인 구조 인력의 배치에도 물놀이장에서의 익수 사고는 꾸준히 발생하고 있다. 본 연구에서는 육안에 의존하는 익수 탐지의 한계를 개선하기 위해, 컴퓨터 비전 기반 딥러닝 모델을 활용한 구조시스템을 제안한다. 다수의 사람이 존재하는 물놀이장 환경에 맞춰 시공간적 행동 탐지 기술로 SlowFast를 활용하며, 모델은 영상 내 등장하는 사람의 행동을 인식한다. 행동 탐지 모델은 Youtube에서 수집한 영상으로 데이터셋을 구축하여 익수와 수영 클래스에 대해 학습하였으며, 실험 결과 최대 52.5%의 mAP@0.5IOU 성능을 달성하였다. 제안하는 시스템에서는 행동 탐지 모델로 탐지된 익수에 대해 발생 구역 번호와 프레임을 포함하는 객체를 생성하고 TTS 음성 알림과 근무자용 웹 애플리케이션 알림을 제공한다. 이를 통해 익수의 탐지와 구조까지의 시간을 단축하여 익수 사고를 예방하고 구조 인력의 부담을 줄이는 효과를 기대할 수 있다. 


Result
===

#### 최종 익수 탐지 모델 시스템 구조도

![image](https://user-images.githubusercontent.com/63159699/208856359-868f8d47-8265-4480-9c88-f777aaf6a593.png)
 
 
#### 탐지 시 웹 애플리케이션 화면

![image](https://user-images.githubusercontent.com/63159699/208855746-a6a9c6e6-fedd-4dae-aade-50f6d4494e53.png)![image](https://user-images.githubusercontent.com/63159699/208855767-7e8cd019-02dc-4fa8-bf74-b228b8612d31.png)



Environment
===

* Operating System : Ubuntu 18.04
* NVIDIA CUDA11 (GPU 개발툴) 이상을 지원하는 GPU 스펙
* python3.8
* 딥러닝 프레임워크 : pytorch 1.8 이상
* 프론트엔드 프레임워크 : Anrdoid Studio – 2021.3.1.16
* 백엔드 프레임워크 : django 3.1.2
* DB : MySQL
* 소켓 통신 서버 : Redis
* 데이터 labeling 툴 : DarkLabel, Ybat
