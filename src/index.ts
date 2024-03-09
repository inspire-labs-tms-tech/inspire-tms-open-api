import { BASE_PATH } from "@inspire-labs-tms-tech/inspire-tms-open-api/gen/base";
import { AboutApi, LoadTendersApi } from "@inspire-labs-tms-tech/inspire-tms-open-api/gen";
export type { paths } from "@inspire-labs-tms-tech/inspire-tms-open-api/gen/openapi";
import OpenAPISpec from "./openapi.json";
import {AxiosInstance} from "axios";

export * from "@inspire-labs-tms-tech/inspire-tms-open-api/gen";

export class InspireTMS {

  private readonly _loadTenderAPI: LoadTendersApi;
  private readonly _aboutAPI: AboutApi;
  private readonly _baseURL: string;

  constructor(app: { name: string; } | { base: string; }, axios?: AxiosInstance) {
    this._baseURL = "base" in app ? app.base.replace(/\/+$/, "") : BASE_PATH.replace("_", app.name);
    this._loadTenderAPI = new LoadTendersApi(undefined, this._baseURL, axios);
    this._aboutAPI = new AboutApi(undefined, this._baseURL, axios);
  }

  public static OpenAPISpec = (): typeof OpenAPISpec => OpenAPISpec;

  get baseURL(): string {
    return this._baseURL;
  }

  get loadTenderAPI(): LoadTendersApi {
    return this._loadTenderAPI;
  }

  get aboutAPI(): AboutApi {
    return this._aboutAPI;
  }

  public static OpenAPIURL(): string {
    return "https://github.com/inspire-labs-tms-tech/inspire-tms-open-api/releases/download/__INSPIRETMS_VERSION__/openapi.yaml";
  }

}