__author__ = "Marcos Chouza Cruces"

import csv
import json

def transformar_fila(fila: dict) -> dict:

    """
    Método encargado de devolver en un diccionario os dun teléfono.

    Args:
        fila(dict): Fila do CSV a transformar
        
    Returns:
        dict: Fila transformada

    Raises:
        ValueError: Se non se pode transformar a fila
    """

    prezo_usa_str = fila["Launched Price (USA)"].replace(",", "").split(" ")[1]
    prezo_usa = float(prezo_usa_str)

    return {
        **fila,
        "Launched Year": int(fila["Launched Year"]),
        "RAM": float(fila["RAM"].replace("GB", "")),
        "Mobile Weight": float(fila["Mobile Weight"].replace("g", "")),
        "Battery Capacity": float(fila["Battery Capacity"].replace("mAh", "").replace(",", ".")),
        "Screen Size": float(fila["Screen Size"].replace("inches", "").strip()),
        "Launched Price (USA)": prezo_usa,
        "Launched Price (UE)": prezo_usa * 0.89
    }

# Abrimos o CSV en modo lectura
with open("Telefonos.csv", "r") as arquivo_csv:
    lector_csv = csv.DictReader(arquivo_csv)

    datosConvertidos = list(
        map(transformar_fila,
            filter(lambda fila: fila["Launched Year"] == "2024", lector_csv)
        )
    )

# Gardamos o resultado en JSON
with open("Telefonos.json", "w") as arquivo_json:
    json.dump(datosConvertidos, arquivo_json, indent=4, ensure_ascii=False)
