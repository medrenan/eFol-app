# Docker Readme

## Requisitos
  - Docker + Docker-Compose

## Instruções
  ### Execução
    - Execute os seguintes comandos no diretório raiz do projeto?
    ```bash
      docker-compose -f efol-core/docker-compose.yml up
    ```
    > Caso queira que o container seja executado em segundo plano, adicione a opção `-d` após o up
    ```bash
      docker-compose -f efol-core/docker-compose.yml up -d
    ```